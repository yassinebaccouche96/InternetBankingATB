package com.internetBankingATB.services;

import java.util.List;

import com.internetBankingATB.models.User;

public interface UserService {
	
	void addUser(User user);
	void deleteUser(User user);
	User getUserByLogin(String login);
	List<User> getUsers();
	

}
