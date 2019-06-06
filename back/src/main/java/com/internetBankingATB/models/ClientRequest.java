package com.internetBankingATB.models;

import com.internetBankingATB.enums.ClientRequestStatus;
import com.internetBankingATB.enums.ClientRequestType;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Data
public class ClientRequest implements Serializable {

    private static final long serialVersionUID = 4785563038595505081L;

    @GeneratedValue
    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private ClientRequestType type;
    @Enumerated(EnumType.STRING)
    private ClientRequestStatus status;

    private Date creationDate;

    @ManyToOne
    private ApplicationUser client;

    @ManyToOne
    private Checks check;

}
