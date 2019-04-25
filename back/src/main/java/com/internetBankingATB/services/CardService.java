package com.internetBankingATB.services;

import java.util.List;

import com.internetBankingATB.models.Card;

public interface CardService {

	void addCard(Card card);

	void deleteCard(Card card);

	List<Card> getCardByNum(Integer cardNumber);

	List<Card> getCards();

}
