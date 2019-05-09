package com.internetBankingATB.services.impl;

import com.internetBankingATB.models.ApplicationUser;
import com.internetBankingATB.repositories.UserRepository;
import com.internetBankingATB.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository useRepository;

    @Override
    public void addUser(ApplicationUser user) {
        user.setCreationDate(new Date());
        this.useRepository.save(user);
    }

    @Override
    public void deleteUser(ApplicationUser user) {
        this.useRepository.delete(user);
    }

    @Override
    public ApplicationUser getUserByLogin(String login) {
        return this.useRepository.findByLogin(login).stream().findFirst().get();
    }

    @Override
    public List<ApplicationUser> getUsers() {
        return this.useRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String userLogin) throws UsernameNotFoundException {
        // continue here
        List<ApplicationUser> user = this.useRepository.findByLogin(userLogin);
        if (user == null || user.isEmpty()) {
            throw new UsernameNotFoundException(userLogin);
        }
        return user.get(0);
    }
}