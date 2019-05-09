package com.internetBankingATB.repositories;

import com.internetBankingATB.models.Account;
import com.internetBankingATB.models.ApplicationUser;
import com.internetBankingATB.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findAccountByUserLogin(String userLogin);

}
