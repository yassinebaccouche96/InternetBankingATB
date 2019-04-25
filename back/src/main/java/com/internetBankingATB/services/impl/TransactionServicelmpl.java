package com.internetBankingATB.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internetBankingATB.models.Transaction;
import com.internetBankingATB.repositories.TransactionRepositrory;
import com.internetBankingATB.services.TransactionService;

@Service
public class TransactionServicelmpl implements TransactionService {

	@Autowired
	private TransactionRepositrory transactionRepository;

	@Override
	public void addTransaction(Transaction transaction) {
		this.transactionRepository.save(transaction);
	}

	@Override
	public void deleteTransaction(Transaction transaction) {
		this.transactionRepository.delete(transaction);
	}

	@Override
	public Transaction getTransactionByid(Long id) {
		return this.transactionRepository.findById(id).get();
	}

	@Override
	public List<Transaction> getTransactions() {
		return this.transactionRepository.findAll();
	}

}
