package com.internetBankingATB.services.impl;

import com.internetBankingATB.models.Card;
import com.internetBankingATB.repositories.CardRepository;
import com.internetBankingATB.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServicelmpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public void addCard(Card card) {
        this.cardRepository.save(card);
    }


    @Override
    public List<Card> findByClientUserName(String userName) {
        return this.cardRepository.findByClientUserName(userName);
    }

    @Override
    public List<Card> findByAccountNumber(String accountNumber) {
        return this.cardRepository.findByAccount_AccountNumber(accountNumber);
    }

}
