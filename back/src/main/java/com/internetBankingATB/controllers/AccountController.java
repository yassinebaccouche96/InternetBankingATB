package com.internetBankingATB.controllers;

import com.internetBankingATB.facades.UserAccountFacade;
import com.internetBankingATB.models.Account;
import com.internetBankingATB.models.ApplicationUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

    private UserAccountFacade userAccountFacade;

    public AccountController(UserAccountFacade userAccountFacade) {
        this.userAccountFacade = userAccountFacade;
    }

    @PostMapping(value = "/add")
    public void addUser(@RequestBody Account account, @AuthenticationPrincipal final String userName) {
        this.userAccountFacade.addAccount(account, userName);
    }

    @GetMapping(value = "/user/accounts")
    public ResponseEntity<List<Account>> getUserAccounts(@AuthenticationPrincipal final String userName) {
        List<Account> userAccounts = this.userAccountFacade.findAccountByUserLogin(userName);
        return new ResponseEntity<>(userAccounts, HttpStatus.OK);
    }

}
