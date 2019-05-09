package com.internetBankingATB.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Transaction implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    // FIXME do Enum
    private String transactionType;

    private Date transactionDate;

    private BigDecimal amount;

    private String description;

    private String ribAccountSenderOrReceive;

    @ManyToOne
    private Account account;

    @ManyToOne
    private Card card;

    private BigDecimal accountBalance;

}
