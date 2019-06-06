package com.internetBankingATB.models;

import com.internetBankingATB.enums.CheckType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Checks {

    @Id
    @GeneratedValue
    private Long id;

    private CheckType checkType;

    @ManyToOne
    private ApplicationUser client;

    private Date deliveryDate;

    private Integer startNum;

    private Integer endNum;

    @ManyToOne
    private Account account;

    private Boolean activated;

    @OneToMany

    private List<ClientRequest> checkRequests;

}