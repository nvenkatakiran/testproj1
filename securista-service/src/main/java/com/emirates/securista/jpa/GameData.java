package com.emirates.securista.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean valid;
	private int levelCode;
	private int eachQScore;

	private List<Question> questions;

	public GameData() {
		super();
	}

	public GameData(boolean valid, int levelCode, int eachQScore, List<Question> questions) {
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

	public List<Question> getQuestions() {
		if(questions == null){
			questions = new ArrayList<Question>();
		}
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public static GameData getInvalidDummyDto(String levelCode) {
		int level = Integer.valueOf(levelCode).intValue();
		int score = level * 100;

		GameData dto = new GameData(false, level, score, null);

		return dto;
	}

	public static GameData getDummyQuestions(String levelCode) {
		int level = Integer.valueOf(levelCode).intValue();
		int score = level * 100;

		List<Question> questions = new ArrayList<Question>();

		for (int i = 1; i <= 27; i++) {
			questions.add(Question.getDummyQ(i, level));
		}

		GameData dto = new GameData(true, level, score, questions);

		return dto;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

}
