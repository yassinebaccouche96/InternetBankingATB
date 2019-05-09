package com.internetBankingATB.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internetBankingATB.models.Card;

public interface CardRepository extends JpaRepository<Card, Long> {

	List<Card> findByCardNumber(Integer carNumber);

	List<Card> findByClientUserName(String userName);

	List<Card> findByAccount_AccountNumber(String accountNumber);
}
