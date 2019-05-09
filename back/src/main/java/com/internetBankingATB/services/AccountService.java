package com.internetBankingATB.services;

import com.internetBankingATB.models.Account;

import java.util.List;


public interface AccountService {

    void save(Account account);

    void delete(Account account);

    List<Account> findAccountByUserLogin(String userLogin);


}
