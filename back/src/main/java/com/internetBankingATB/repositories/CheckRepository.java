package com.internetBankingATB.repositories;

import com.internetBankingATB.models.Checks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckRepository extends JpaRepository<Checks, Long> {

    List<Checks> findByClient_UserNameAndAccount_AccountName(final String userName, final String accountNumber);

    List<Checks> findByClient_UserNameAndActivatedTrue(final String userName);

}
