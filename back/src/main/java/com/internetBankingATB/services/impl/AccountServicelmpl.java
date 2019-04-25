package com.internetBankingATB.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internetBankingATB.models.Account;
import com.internetBankingATB.repositories.AccountRepository;
import com.internetBankingATB.services.AccountService;

@Service
public class AccountServicelmpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public void addCompte(Account compte) {
		this.accountRepository.save(compte);
	}

	@Override
	public void deleteCompte(Account compte) {
		this.accountRepository.delete(compte);
	}

	@Override
	public Account getCompteBynumerocompte(Long numerocompte) {
		// return this.accountRepository.findBynumerocompte(numerocompte).stream().findFirst().get();
		return null;
	}

	@Override
	public List<Account> getComptes() {
		return this.accountRepository.findAll();
	}

}
