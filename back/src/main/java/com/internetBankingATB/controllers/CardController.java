package com.internetBankingATB.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internetBankingATB.models.Card;

import com.internetBankingATB.services.CardService;

@RestController
@RequestMapping(value = "/Card")

public class CardController {

	@Autowired
	CardService cardService;

	@GetMapping(value = "/Card")
	public List<Card> getCards() {
		return this.cardService.getCards();
	}

	@PostMapping(value = "/addCard")
	public void addCard(@RequestBody Card card) {
		this.cardService.addCard(card);

	}

}
