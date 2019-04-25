package com.internetBankingATB.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internetBankingATB.models.Checks;

public interface CheckRepository extends JpaRepository<Checks, Long> {

	// List<Checks> findBycheckNumber(Long checkNumber);

}
