package com.emirates.securista.service;

import com.emirates.securista.dto.GameDataDto;
import com.emirates.securista.dto.UserInformationDto;

public interface SecuristaService {

	UserInformationDto epinAuthenticate(String staffNo, String epin);
	
	GameDataDto loadQuestions(String staffNo, String levelCode, String authCode);
	
	boolean saveQuestionsToDB();
}
