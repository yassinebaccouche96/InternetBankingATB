package com.internetBankingATB.models;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Data
public class Account implements Serializable {

	private static final long serialVersionUID = -567814031651784572L;


	@Id
	@GeneratedValue
	private Long id;

	private String accountNumber;

	private String accountName;
	// FIXME create accountType Enum
	private String accountType;
	private String rib;
	// solde
	private BigDecimal balance;

	// FIXME create currency enum
	private String currency;

	@ManyToOne
	private ApplicationUser user;

	@OneToMany
	private List<Card> cards;

	@OneToMany
	private List<Transaction> transactions;

	private Date creationDate;

	private Double debtorInterestRate;
}
