package com.internetBankingATB.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internetBankingATB.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findByLogin(String login);

}
