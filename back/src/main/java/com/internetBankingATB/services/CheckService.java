package com.internetBankingATB.services;

import com.internetBankingATB.enums.CheckType;
import com.internetBankingATB.models.Checks;

import java.util.List;


public interface CheckService {

    List<Checks> findByClientNameAndAccountNumber(final String clientName, final String accountNumber);

    List<Checks> findByClientName(final String clientName);

    void add(Checks check);

    List<CheckType> findCheckTypes();

}
