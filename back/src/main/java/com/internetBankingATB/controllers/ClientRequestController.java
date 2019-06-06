package com.internetBankingATB.controllers;

import com.internetBankingATB.enums.ClientRequestStatus;
import com.internetBankingATB.enums.ClientRequestType;
import com.internetBankingATB.models.ClientRequest;
import com.internetBankingATB.services.ClientRequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/clientRequest")
public class ClientRequestController {

    private ClientRequestService clientRequestService;

    public ClientRequestController(ClientRequestService clientRequestService) {
        this.clientRequestService = clientRequestService;
    }


    @PostMapping("/add")
    public ResponseEntity addClientRequest(@RequestBody ClientRequest clientRequest,
                                           @AuthenticationPrincipal final String userName) {
        this.clientRequestService.add(clientRequest, userName);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<ClientRequest>> getChecksRequestByStatusAndType() {
        this.clientRequestService.findByStatusAndType(ClientRequestStatus.NEW, ClientRequestType.CHECK_REQUEST);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
