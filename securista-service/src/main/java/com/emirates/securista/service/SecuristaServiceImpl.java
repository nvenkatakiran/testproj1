package com.emirates.securista.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.emirates.securista.dao.SecuristaDAO;
import com.emirates.securista.dto.GameDataDto;
import com.emirates.securista.dto.UserInformationDto;
import com.emirates.securista.jpa.GameData;
import com.emirates.securista.jpa.Question;

@Service(value = "securistaService")
@Transactional(readOnly = false)
public class SecuristaServiceImpl implements SecuristaService {

	private static Map<String, String> authCodesMap = new HashMap<String, String>();

	@Autowired
	private SecuristaDAO securistaDAO;

	Map<String, Map<String, List<Integer>>> qtnsByLevelAgainstStaffMap = new HashMap<String, Map<String, List<Integer>>>();
	static final int Q_COUNT_PER_GAME = 9;

	@Override
	public UserInformationDto epinAuthenticate(String staffNo, String epin) {

		long id = 0l;
		String staff = staffNo;
		String staffName = "Venkata Nidumukkala";
		String testTakenYN = "N";
		int numberOfAttempts = 0;
		boolean validUser = true;

		boolean level1Completed = false;
		boolean level2Completed = false;
		boolean level3Completed = false;
		int level1Attempts = 0;
		int level2Attempts = 0;
		int level3Attempts = 0;
		int level1Score = 0;
		int level2Score = 0;
		int level3Score = 0;

		String authCode = String.valueOf(Calendar.getInstance().getTimeInMillis());

		authCodesMap.put(staff, authCode);

		UserInformationDto userInfo = new UserInformationDto(id, staff, staffName, testTakenYN, numberOfAttempts,
				validUser, level1Completed, level2Completed, level3Completed, level1Attempts, level2Attempts,
				level3Attempts, level1Score, level2Score, level3Score, authCode);

		return userInfo;
	}

	@Override
	public GameDataDto loadQuestions(String staffNo, String levelCode, String authCode) {
		/*
		 * Pre-validate authentication code, if auth code not exists against
		 * employee, then return error.
		 */
		String authCodeFromDb = authCodesMap.get(staffNo);
		if (StringUtils.isEmpty(authCodeFromDb) || !authCodeFromDb.equalsIgnoreCase(authCode)) {
			return GameDataDto.getInvalidDummyDto(levelCode);
		}

		GameData gameData = securistaDAO.loadQuestions(levelCode, authCode);
		if (gameData.getQuestions().size() > Q_COUNT_PER_GAME) {
			Random random = new Random();
			int boundary = gameData.getQuestions().size();
			IntStream intsStream = random.ints(0, boundary).limit(Q_COUNT_PER_GAME);
			/*
			 * intsStream.forEach((i) -> { System.out.println("***** " + (i -
			 * 1)); });
			 */

			List<Integer> list = intsStream.boxed().collect(Collectors.toList());
			List<Integer> listToConsider = new ArrayList<Integer>();
			list.forEach(i -> {
				if (!currentPositionAlreadyAdded(staffNo, levelCode, i, boundary)) {
					listToConsider.add(i);
				}
			});

			/*
			 * Remove duplicates, After this if questions count is Less than
			 * Required number of questions for the game then need to form the
			 * same.
			 */
			HashSet<Integer> set = new HashSet<Integer>(listToConsider);
			if (set.size() < Q_COUNT_PER_GAME) {
				for (;;) {
					if (set.size() >= Q_COUNT_PER_GAME) {
						break;
					}
					int newPos = random.nextInt(boundary);
					if (!set.contains(newPos) && !currentPositionAlreadyAdded(staffNo, levelCode, newPos, boundary)) {
						set.add(newPos);
					}
				}
			}

			List<Question> curQuestions = gameData.getQuestions();
			List<Question> finalQuestions = new ArrayList<Question>();
			set.forEach(i -> finalQuestions.add(curQuestions.get(i)));
			gameData.setQuestions(finalQuestions);

			/*
			 * Maintain Unique Questions and Random order against staff.
			 */
			Map<String, List<Integer>> questionsByLevelGrp = qtnsByLevelAgainstStaffMap.get(staffNo);
			if (questionsByLevelGrp == null) {
				questionsByLevelGrp = new HashMap<String, List<Integer>>();
			}
			List<Integer> listOfQuestByLevel = questionsByLevelGrp.get(levelCode);
			if (listOfQuestByLevel == null) {
				listOfQuestByLevel = new ArrayList<Integer>();
			}
			listOfQuestByLevel.addAll(new ArrayList<Integer>(set));

			System.out.println("***********************");
			questionsByLevelGrp.forEach((k, v) -> {
				System.out.println("Level Code :: " + k);
				System.out.println(v);
			});

			if (listOfQuestByLevel.size() >= boundary) {
				listOfQuestByLevel = new ArrayList<Integer>();
			}
			questionsByLevelGrp.put(levelCode, listOfQuestByLevel);
			qtnsByLevelAgainstStaffMap.put(staffNo, questionsByLevelGrp);

			// tmpList.add(new ArrayList<Integer>(set));
			// tmpList.forEach(i -> System.out.println(i));

		}

		GameDataDto dto = new GameDataDto();
		BeanUtils.copyProperties(gameData, dto);
		return dto;
	}

	private boolean currentPositionAlreadyAdded(String staffNo, String levelCode, int positionNo, int totalQSize) {
		Map<String, List<Integer>> questionsByLevelGrp = qtnsByLevelAgainstStaffMap.get(staffNo);
		if (questionsByLevelGrp == null) {
			return false;
		}
		List<Integer> qPosListByLevel = questionsByLevelGrp.get(levelCode);
		if (qPosListByLevel == null || qPosListByLevel.size() == 0) {
			return false;
		}

		return (qPosListByLevel.contains(Integer.valueOf(positionNo)));
	}

	@Override
	public boolean saveQuestionsToDB() {

		return securistaDAO.saveQuestionsToDB();
	}

}
