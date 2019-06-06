package com.internetBankingATB.repositories;

import com.internetBankingATB.enums.ClientRequestStatus;
import com.internetBankingATB.enums.ClientRequestType;
import com.internetBankingATB.models.ClientRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRequestRepository extends JpaRepository<ClientRequest, Long> {

    List<ClientRequest> findByStatusEqualsAndTypeEquals(ClientRequestStatus clientRequestStatus,
                                                         ClientRequestType clientRequestType);
}
