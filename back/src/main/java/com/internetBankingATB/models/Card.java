
package com.internetBankingATB.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.internetBankingATB.enums.CardType;
import lombok.Data;

@Entity
@Data
public class Card implements Serializable {

	private static final long serialVersionUID = 4783563038595505081L;

	@Id
	@GeneratedValue
	private Long id;

	private String cardNumber;

	private CardType cardType;

	// TODO save account number

	// plafond
	private Long ceiling;

	private Date expirationDate;

	// FIXME enum for status: blocked non blocked
	private String status;

	// FIXME enum for action: differed or immediate
	private String action;

	private BigDecimal usedAmount;

	@ManyToOne
	private ApplicationUser client;

	// date echeance
	private Date deadline;

	@ManyToOne
	private Account account;

	@OneToMany
	private List<Transaction> transactions;

}
