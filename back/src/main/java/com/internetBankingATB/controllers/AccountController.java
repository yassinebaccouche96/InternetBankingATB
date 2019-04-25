package com.internetBankingATB.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internetBankingATB.models.Account;

import com.internetBankingATB.services.AccountService;

@RestController
@RequestMapping(value = "/compte")
public class AccountController {

	@Autowired
	AccountService AccountService;

	@GetMapping(value = "/compte")
	public List<Account> getComptes() {
		return this.AccountService.getComptes();
	}

	@PostMapping(value = "/addCompte")
	public void addUser(@RequestBody Account compte) {
		this.AccountService.addCompte(compte);

	}

}
