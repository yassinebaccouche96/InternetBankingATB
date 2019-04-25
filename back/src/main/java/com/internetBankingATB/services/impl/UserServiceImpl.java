package com.internetBankingATB.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internetBankingATB.models.User;
import com.internetBankingATB.repositories.UserRepository;
import com.internetBankingATB.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository useRepository;

    @Override
    public void addUser(User user) {
        user.setCreationDate(new Date());
        this.useRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        this.useRepository.delete(user);
    }

    @Override
    public User getUserByLogin(String login) {
        return this.useRepository.findByLogin(login).stream().findFirst().get();
    }

    @Override
    public List<User> getUsers() {
        return this.useRepository.findAll();
    }

}