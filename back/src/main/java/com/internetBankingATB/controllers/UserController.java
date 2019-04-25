package com.internetBankingATB.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.internetBankingATB.models.User;
import com.internetBankingATB.services.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/users")
	public ResponseEntity<List<User>> getUsers() {
		List<User> users =  this.userService.getUsers();
		return  new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PostMapping(value="/addUser")
	public void addUser(@RequestBody User user) {
		this.userService.addUser(user);

	}

}
