package com.emirates.securista.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emirates.securista.dto.GameDataDto;
import com.emirates.securista.dto.UserInformationDto;
import com.emirates.securista.service.SecuristaService;

@SpringBootApplication
@ComponentScan(basePackages = "com.emirates")
public class SecuristaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuristaServiceApplication.class, args);
	}
}

@RestController
class SecuristaRESTService {

	@Autowired
	private SecuristaService securistaService;

	@RequestMapping("/epinAuthenticate")
	@CrossOrigin(origins = "http://localhost:8100")
	UserInformationDto epinAuthenticate(@RequestParam String staffNo, @RequestParam String epin) {

		return securistaService.epinAuthenticate(staffNo, epin);
	}

	@RequestMapping("/loadGameInformation")
	@CrossOrigin(origins = "http://localhost:8100")
	GameDataDto loadGameInformation(@RequestParam String levelCode, @RequestParam String staffNo,
			@RequestParam String authCode) {
		return securistaService.loadQuestions(staffNo, levelCode, authCode);
	}

	@RequestMapping("/saveDummyQuestions")
	@CrossOrigin(origins = "http://localhost:8100")
	void saveDummyQuestions() {
		securistaService.saveQuestionsToDB();
	}

}
