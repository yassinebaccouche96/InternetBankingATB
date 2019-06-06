package com.internetBankingATB.services;

import com.internetBankingATB.enums.ClientRequestStatus;
import com.internetBankingATB.enums.ClientRequestType;
import com.internetBankingATB.models.ClientRequest;

import java.util.List;

public interface ClientRequestService {

    void add(ClientRequest clientRequest, final String userName);

    List<ClientRequest> findByStatusAndType(final ClientRequestStatus clientRequestStatus,
                                                      final ClientRequestType clientRequestType);

}
