package com.internetBankingATB.services;

import java.util.List;

import com.internetBankingATB.models.ApplicationUser;

public interface UserService {
	
	void addUser(ApplicationUser user);
	void deleteUser(ApplicationUser user);
	ApplicationUser getUserByLogin(String login);
	List<ApplicationUser> getUsers();
	

}
