package com.internetBankingATB.controllers;

import com.internetBankingATB.models.ApplicationUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "authentication")
public class Authentication {

	@PostMapping(path = "authenticate")
	public ResponseEntity<ApplicationUser> authenticate() {
		return null;
	}


}
