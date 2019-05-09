package com.internetBankingATB.controllers;

import com.internetBankingATB.models.Account;
import com.internetBankingATB.models.ApplicationUser;
import com.internetBankingATB.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/users")
	public ResponseEntity<List<ApplicationUser>> getUsers() {
		List<ApplicationUser> users = this.userService.getUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PostMapping(value = "/addUser")
	public void addUser(@RequestBody ApplicationUser user) {
		this.userService.addUser(user);
	}

	@GetMapping(value = "/accounts")
	public ResponseEntity<List<Account>> getUserAccounts(@AuthenticationPrincipal final ApplicationUser cuurentUser) {
		return null;
	}

}
