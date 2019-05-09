package com.internetBankingATB.services.impl;

import com.internetBankingATB.models.Account;
import com.internetBankingATB.repositories.AccountRepository;
import com.internetBankingATB.services.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServicelmpl implements AccountService {


    private AccountRepository accountRepository;


    public AccountServicelmpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void save(Account account) {
        this.accountRepository.save(account);
    }

    @Override
    public void delete(Account account) {
        this.accountRepository.delete(account);

    }

    @Override
    public List<Account> findAccountByUserLogin(String userLogin) {
        return this.accountRepository.findAccountByUserLogin(userLogin);
    }
}
