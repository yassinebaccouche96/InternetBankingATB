package com.internetBankingATB.services.impl;

import com.internetBankingATB.enums.CheckType;
import com.internetBankingATB.models.Checks;
import com.internetBankingATB.repositories.CheckRepository;
import com.internetBankingATB.services.CheckService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CheckServicelmpl implements CheckService {

    private CheckRepository checkRepository;

    public CheckServicelmpl(CheckRepository checkRepository) {
        this.checkRepository = checkRepository;
    }


    @Override
    public List<Checks> findByClientNameAndAccountNumber(final String clientName, final String accountNumber) {
        return this.checkRepository.findByClient_UserNameAndAccount_AccountName(clientName, accountNumber);
    }

    @Override
    public List<Checks> findByClientName(String clientName) {
        return this.checkRepository.findByClient_UserNameAndActivatedTrue(clientName);
    }

    @Override
    public void add(Checks check) {
        this.checkRepository.save(check);
    }

    @Override
    public List<CheckType> findCheckTypes() {
        return Arrays.asList(CheckType.values());
    }


}
