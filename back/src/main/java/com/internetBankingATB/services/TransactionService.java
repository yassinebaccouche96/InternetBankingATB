package com.internetBankingATB.services;

import com.internetBankingATB.models.Transaction;

import java.util.List;


public interface TransactionService {

	List<Transaction> findTransactionByAccountNumber(String accountNumber);

	List<Transaction> findTransactionByAccountNumberAndCardIsNotNull(String accountNumber);

}
