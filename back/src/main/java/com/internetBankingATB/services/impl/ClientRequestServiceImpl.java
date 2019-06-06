package com.internetBankingATB.services.impl;

import com.internetBankingATB.enums.ClientRequestStatus;
import com.internetBankingATB.enums.ClientRequestType;
import com.internetBankingATB.models.ApplicationUser;
import com.internetBankingATB.models.ClientRequest;
import com.internetBankingATB.repositories.ClientRequestRepository;
import com.internetBankingATB.services.CheckService;
import com.internetBankingATB.services.ClientRequestService;
import com.internetBankingATB.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClientRequestServiceImpl implements ClientRequestService {

    private ClientRequestRepository clientRequestRepository;
    private CheckService checkService;
    private UserService userService;

    public ClientRequestServiceImpl(ClientRequestRepository clientRequestRepository,
                                    CheckService checkService,
                                    UserService userService) {
        this.clientRequestRepository = clientRequestRepository;
        this.checkService = checkService;
        this.userService = userService;
    }

    @Override
    public void add(ClientRequest clientRequest, final String userName) {
        // find current user
        ApplicationUser user = this.userService.getUserByLogin(userName);
        clientRequest.setClient(user);
        this.updateClientRequest(clientRequest);

        if (clientRequest.getCheck() != null) {
            clientRequest.getCheck().setClient(user);
            this.checkService.add(clientRequest.getCheck());
        }

        this.clientRequestRepository.save(clientRequest);
    }

    @Override
    public List<ClientRequest> findByStatusAndType(final ClientRequestStatus clientRequestStatus,
                                                               final ClientRequestType clientRequestType) {
        return this.clientRequestRepository.findByStatusEqualsAndTypeEquals(clientRequestStatus, clientRequestType);
    }


    private void updateClientRequest(ClientRequest clientRequest) {
        clientRequest.setStatus(ClientRequestStatus.NEW);
        clientRequest.setCreationDate(new Date());
        clientRequest.setType(ClientRequestType.CHECK_REQUEST);
    }
}
