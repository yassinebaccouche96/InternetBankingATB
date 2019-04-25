package com.internetBankingATB.services;

import java.util.List;

import com.internetBankingATB.models.Transaction;


public interface TransactionService {
	
	void addTransaction(Transaction transaction);
	
	void deleteTransaction(Transaction transaction);
	
	Transaction getTransactionByid(Long id);
	
	List<Transaction> getTransactions();

}
