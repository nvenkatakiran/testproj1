package com.emirates.securista.dao;

import org.springframework.stereotype.Repository;

import com.emirates.securista.jpa.GameData;

@Repository
public class SecuristaDAOImpl implements SecuristaDAO{

	@Override
	public GameData loadQuestions(String levelCode, String authCode) {
		return GameData.getDummyQuestions(levelCode);
	}

	@Override
	public boolean saveQuestionsToDB() {
		return false;
	}

}
