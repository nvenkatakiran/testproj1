package com.emirates.securista.dao;

import com.emirates.securista.jpa.GameData;

public interface SecuristaDAO {
	
	GameData loadQuestions(String levelCode, String authCode);
	
	boolean saveQuestionsToDB();
}
