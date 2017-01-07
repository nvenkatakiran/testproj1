package com.emirates.securista.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QuestionDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long questionId;
	private String question;
	private String clue;
	private int numOfOptions;
	private int correctOptionsCount;
	private List<String> options;
	private String answerOpt;
	private String optionsToSkipFr5050;

	public QuestionDto() {
		super();
	}

	public QuestionDto(long questionId, String question, String answerOpt, String clue, int numOfOptions,
			int correctOptionsCount, List<String> options, String optionsToSkipFr5050) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answerOpt = answerOpt;
		this.clue = clue;
		this.numOfOptions = numOfOptions;
		this.correctOptionsCount = correctOptionsCount;
		this.options = options;
		this.optionsToSkipFr5050 = optionsToSkipFr5050;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswerOpt() {
		return answerOpt;
	}

	public void setAnswerOpt(String answerOpt) {
		this.answerOpt = answerOpt;
	}

	public String getClue() {
		return clue;
	}

	public void setClue(String clue) {
		this.clue = clue;
	}

	public int getNumOfOptions() {
		return numOfOptions;
	}

	public void setNumOfOptions(int numOfOptions) {
		this.numOfOptions = numOfOptions;
	}

	public int getCorrectOptionsCount() {
		return correctOptionsCount;
	}

	public void setCorrectOptionsCount(int correctOptionsCount) {
		this.correctOptionsCount = correctOptionsCount;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public String getOptionsToSkipFr5050() {
		return optionsToSkipFr5050;
	}

	public void setOptionsToSkipFr5050(String optionsToSkipFr5050) {
		this.optionsToSkipFr5050 = optionsToSkipFr5050;
	}

	public static QuestionDto getDummyQ(int id, int levelCode) {
		long questionId = id;
		String question = "Question Number " + id
				+ ", Lorem epsum Lorem epsum Lorem epsum Lorem epsum Lorem epsum Lorem epsum Lorem epsum Lorem epsum Lorem epsum Lorem epsum Lorem epsum";
		String answerOpt = "3";
		if(levelCode == 2){
			answerOpt = "1,3";
		}
		else if(levelCode == 3){
			answerOpt = "2,3,5";
		}
		String clue = "Checkgroupworld..section 3.4.1";
		int numOfOptions = 4;
		if(levelCode == 3){
			numOfOptions = 6;
		}
		int correctOptionsCount = levelCode;
		List<String> options = new ArrayList<String>();
		for (int i = 1; i <= numOfOptions; i++) {
			options.add("Option " + id + "-" + i);
		}
		String optionsToSkipFr5050 = "1,4";
		if (levelCode == 2) {
			optionsToSkipFr5050 = "1";
		} else if (levelCode == 3) {
			optionsToSkipFr5050 = "1,8";
		}

		QuestionDto dto = new QuestionDto(questionId, question, answerOpt, clue, numOfOptions, correctOptionsCount,
				options, optionsToSkipFr5050);

		return dto;
	}
}
