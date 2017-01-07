package com.emirates.securista.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameDataDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean valid;
	private int levelCode;
	private int eachQScore;

	private List<QuestionDto> questions;

	public GameDataDto() {
		super();
	}

	public GameDataDto(boolean valid, int levelCode, int eachQScore, List<QuestionDto> questions) {
		super();
		this.valid = valid;
		this.levelCode = levelCode;
		this.eachQScore = eachQScore;
		this.questions = questions;
	}

	public int getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(int levelCode) {
		this.levelCode = levelCode;
	}

	public int getEachQScore() {
		return eachQScore;
	}

	public void setEachQScore(int eachQScore) {
		this.eachQScore = eachQScore;
	}

	public List<QuestionDto> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionDto> questions) {
		this.questions = questions;
	}

	public static GameDataDto getInvalidDummyDto(String levelCode) {
		int level = Integer.valueOf(levelCode).intValue();
		int score = level * 100;

		GameDataDto dto = new GameDataDto(false, level, score, null);

		return dto;
	}

	public static GameDataDto getDummyQuestions(String levelCode) {
		int level = Integer.valueOf(levelCode).intValue();
		int score = level * 100;

		List<QuestionDto> questions = new ArrayList<QuestionDto>();

		for (int i = 1; i <= 9; i++) {
			questions.add(QuestionDto.getDummyQ(i, level));
		}

		GameDataDto dto = new GameDataDto(true, level, score, questions);

		return dto;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

}
