package com.internetBankingATB.facades;

import com.internetBankingATB.models.Account;
import com.internetBankingATB.models.ApplicationUser;
import com.internetBankingATB.services.AccountService;
import com.internetBankingATB.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountFacade {

	private AccountService accountService;

	private UserService userService;

	public UserAccountFacade(AccountService accountService, UserService userService) {
		this.accountService = accountService;
		this.userService = userService;
	}

	public List<Account> findAccountByUserLogin(String userLogin) {
		return this.accountService.findAccountByUserLogin(userLogin);
	}

	public void addAccount(Account account, String userName) {
		ApplicationUser user = this.userService.getUserByLogin(userName);
		if (user != null) {
			account.setUser(user);
			this.accountService.save(account);
		} else {
			// FIXME throw UserNotFoundException
		}
	}


}
