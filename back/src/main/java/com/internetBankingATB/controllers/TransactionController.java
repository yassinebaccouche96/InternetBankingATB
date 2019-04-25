package com.internetBankingATB.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internetBankingATB.models.Transaction;
import com.internetBankingATB.services.TransactionService;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {
	
	
	@Autowired
	TransactionService transactionService;

	@GetMapping(value = "/transaction")
	public List<Transaction> getTransactions() {
		return this.transactionService.getTransactions();
	}

	@PostMapping(value="/addTransaction")
	public void addTransaction(@RequestBody Transaction transaction) {
		this.transactionService.addTransaction(transaction);

	}


}
