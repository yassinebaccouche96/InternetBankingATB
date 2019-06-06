package com.internetBankingATB.controllers;

import com.internetBankingATB.enums.CheckType;
import com.internetBankingATB.models.Checks;
import com.internetBankingATB.services.CheckService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/check")
public class CheckController {

    private CheckService checkService;

    public CheckController(CheckService checkService) {
        this.checkService = checkService;
    }

    @GetMapping(value = "/checks/{accountNumber}")
    public List<Checks> getChecksAccountNumberAndUserName(@PathVariable("accountNumber") final String accountNumber,
                                                          @AuthenticationPrincipal final String userName) {
        return this.checkService.findByClientNameAndAccountNumber(userName, accountNumber);
    }

    @GetMapping(value = "/checks/byUserName")
    public List<Checks> getChecksUserName(@AuthenticationPrincipal final String userName) {
        return this.checkService.findByClientName(userName);
    }

    @GetMapping(value = "/checkTypes")
    public ResponseEntity<List<CheckType>> checkType() {
        return new ResponseEntity<>(this.checkService.findCheckTypes(), HttpStatus.OK);
    }


}
