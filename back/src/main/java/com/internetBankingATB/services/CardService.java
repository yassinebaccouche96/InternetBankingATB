package com.internetBankingATB.services;

import com.internetBankingATB.models.Card;

import java.util.List;

public interface CardService {

    void addCard(Card card);

    List<Card> findByClientUserName(String userName);

    List<Card> findByAccountNumber(String accountNumber);

}
