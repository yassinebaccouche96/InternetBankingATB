package com.internetBankingATB.controllers;

import java.util.List;

import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internetBankingATB.services.CheckService;

@RestController
@RequestMapping(value = "/check")
public class CheckController {

	@Autowired
	CheckService checkService;

	@GetMapping(value = "/check")
	public List<Check> getchecks() {
		return this.checkService.getChecks();
	}

	@PostMapping(value = "/addcheck")
	public void addcheck(@RequestBody Check check) {
		this.checkService.addCheck(check);

	}
}
