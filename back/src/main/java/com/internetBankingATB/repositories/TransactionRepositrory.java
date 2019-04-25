package com.internetBankingATB.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internetBankingATB.models.Transaction;

@Repository
public interface TransactionRepositrory extends JpaRepository<Transaction, Long> {

	Optional<Transaction> findById(Long id);

}
