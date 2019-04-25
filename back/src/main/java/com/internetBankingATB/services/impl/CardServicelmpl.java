package com.internetBankingATB.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internetBankingATB.models.Card;
import com.internetBankingATB.repositories.CardRepository;
import com.internetBankingATB.services.CardService;

@Service
public class CardServicelmpl implements CardService {

	@Autowired
	private CardRepository cardRepository;

	@Override
	public void addCard(Card card) {
		this.cardRepository.save(card);
	}

	@Override
	public void deleteCard(Card card) {
		this.cardRepository.delete(card);
	}

	@Override
	public List<Card> getCardByNum(Integer cardNumber) {
		
		return this.cardRepository.findByCardNumber(cardNumber);
	}

	@Override
	public List<Card> getCards() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Card getCardBynumcard(Integer cardNumber) {
//		return this.cardRepository.findBycardNumber(cardNumber).stream().findFirst().get();
//	}

}
