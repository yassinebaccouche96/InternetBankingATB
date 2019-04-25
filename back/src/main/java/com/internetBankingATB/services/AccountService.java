package com.internetBankingATB.services;

import java.util.List;

import com.internetBankingATB.models.Account;


public interface AccountService {
	
	void addCompte(Account compte);
	void deleteCompte(Account compte);
	Account getCompteBynumerocompte(Long numerocompte);
	List<Account> getComptes();
	

}
