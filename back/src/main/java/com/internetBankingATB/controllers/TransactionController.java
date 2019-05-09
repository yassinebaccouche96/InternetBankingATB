package com.internetBankingATB.controllers;

import com.internetBankingATB.models.Transaction;
import com.internetBankingATB.services.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {

    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping(value = "/transactions/{accountNumber}")
    public List<Transaction> getTransactionsByAccountNumber(@PathVariable String accountNumber) {
        return this.transactionService.findTransactionByAccountNumber(accountNumber);
    }

    @GetMapping(value = "/transactions_done_by_account_card/{accountNumber}")
    public List<Transaction> getTransactionsDoneByAccountCard(@PathVariable String accountNumber) {
        return this.transactionService.findTransactionByAccountNumberAndCardIsNotNull(accountNumber);
    }

}
