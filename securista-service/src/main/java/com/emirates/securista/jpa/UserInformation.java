package com.emirates.securista.jpa;

import java.io.Serializable;

public class UserInformation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private String staffNo;
	private String staffName;
	private String testTakenYN;
	private int numberOfAttempts;
	private boolean validUser;
	private boolean level1Completed;
	private boolean level2Completed;
	private boolean level3Completed;
	private int level1Attempts;
	private int level2Attempts;
	private int level3Attempts;
	private int level1Score;
	private int level2Score;
	private int level3Score;
	
	private String authCode;

	public UserInformation() {
		super();
	}

	/*public UserInformation(long id, String saffNo, String staffName, String testTakenYN, int numberOfAttempts,
			boolean validUser) {
		super();
		this.id = id;
		this.saffNo = saffNo;
		this.staffName = staffName;
		this.testTakenYN = testTakenYN;
		this.numberOfAttempts = numberOfAttempts;
		this.validUser = validUser;
	}*/

	public UserInformation(long id, String staffNo, String staffName, String testTakenYN, int numberOfAttempts,
			boolean validUser, boolean level1Completed, boolean level2Completed, boolean level3Completed,
			int level1Attempts, int level2Attempts, int level3Attempts, int level1Score, int level2Score,
			int level3Score, String authCode) {
		super();
		this.id = id;
		this.staffNo = staffNo;
		this.staffName = staffName;
		this.testTakenYN = testTakenYN;
		this.numberOfAttempts = numberOfAttempts;
		this.validUser = validUser;
		this.level1Completed = level1Completed;
		this.level2Completed = level2Completed;
		this.level3Completed = level3Completed;
		this.level1Attempts = level1Attempts;
		this.level2Attempts = level2Attempts;
		this.level3Attempts = level3Attempts;
		this.level1Score = level1Score;
		this.level2Score = level2Score;
		this.level3Score = level3Score;
		this.authCode = authCode;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStaffNo() {
		return staffNo;
	}

	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getTestTakenYN() {
		return testTakenYN;
	}

	public void setTestTakenYN(String testTakenYN) {
		this.testTakenYN = testTakenYN;
	}

	public int getNumberOfAttempts() {
		return numberOfAttempts;
	}

	public void setNumberOfAttempts(int numberOfAttempts) {
		this.numberOfAttempts = numberOfAttempts;
	}

	public boolean isValidUser() {
		return validUser;
	}

	public void setValidUser(boolean validUser) {
		this.validUser = validUser;
	}

	public boolean isLevel1Completed() {
		return level1Completed;
	}

	public void setLevel1Completed(boolean level1Completed) {
		this.level1Completed = level1Completed;
	}

	public boolean isLevel2Completed() {
		return level2Completed;
	}

	public void setLevel2Completed(boolean level2Completed) {
		this.level2Completed = level2Completed;
	}

	public boolean isLevel3Completed() {
		return level3Completed;
	}

	public void setLevel3Completed(boolean level3Completed) {
		this.level3Completed = level3Completed;
	}

	public int getLevel1Attempts() {
		return level1Attempts;
	}

	public void setLevel1Attempts(int level1Attempts) {
		this.level1Attempts = level1Attempts;
	}

	public int getLevel2Attempts() {
		return level2Attempts;
	}

	public void setLevel2Attempts(int level2Attempts) {
		this.level2Attempts = level2Attempts;
	}

	public int getLevel3Attempts() {
		return level3Attempts;
	}

	public void setLevel3Attempts(int level3Attempts) {
		this.level3Attempts = level3Attempts;
	}

	public int getLevel1Score() {
		return level1Score;
	}

	public void setLevel1Score(int level1Score) {
		this.level1Score = level1Score;
	}

	public int getLevel2Score() {
		return level2Score;
	}

	public void setLevel2Score(int level2Score) {
		this.level2Score = level2Score;
	}

	public int getLevel3Score() {
		return level3Score;
	}

	public void setLevel3Score(int level3Score) {
		this.level3Score = level3Score;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

}
