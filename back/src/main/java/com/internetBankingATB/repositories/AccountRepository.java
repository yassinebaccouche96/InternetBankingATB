package com.internetBankingATB.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internetBankingATB.models.Account;



public interface AccountRepository extends JpaRepository<Account, Long> {

	// List<Account> findBynumerocompte(Long numerocompte);
}
