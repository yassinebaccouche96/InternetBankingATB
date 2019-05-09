package com.internetBankingATB.controllers;

import com.internetBankingATB.models.Card;
import com.internetBankingATB.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/card")

public class CardController {


   private CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping(value = "/addCard")
    public void addCard(@RequestBody Card card) {
        this.cardService.addCard(card);
    }

    @GetMapping(value = "/cards/user")
    public ResponseEntity<List<Card>> getCardByUserName(@AuthenticationPrincipal final String userName) {
        return new ResponseEntity
                (this.cardService.findByClientUserName(userName), HttpStatus.OK);
    }

    @GetMapping(value = "/account/{accountNumber}")
    public ResponseEntity<Card> getCardByAccountNumber(@PathVariable("accountNumber") String accountNumber) {
        return new ResponseEntity
                (this.cardService.findByAccountNumber(accountNumber), HttpStatus.OK);
    }

}
