package com.internetBankingATB.services.impl;

import com.internetBankingATB.models.Transaction;
import com.internetBankingATB.repositories.TransactionRepository;
import com.internetBankingATB.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServicelmpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Transaction> findTransactionByAccountNumber(String accountNumber) {
        return this.transactionRepository.findTransactionByAccount_AccountNumberOrderByTransactionDate(accountNumber);
    }

    @Override
    public List<Transaction> findTransactionByAccountNumberAndCardIsNotNull(String accountNumber) {
        return this.transactionRepository.findTransactionByAccount_AccountNumberAndCardIsNotNull(accountNumber);
    }

}
