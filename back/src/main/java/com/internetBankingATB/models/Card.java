
package com.internetBankingATB.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.internetBankingATB.enums.CardType;

@Entity
public class Card {

	@Id
	@GeneratedValue
	private Long id;

	private Integer cardNumber;

	private CardType cardType;

	// TODO add account number

	// plafond
	private Long ceiling;

	private Date expirationDate;

	// FIXME enum for status: blocked non blocked
	private String status;

	// FIXME enum for action: differed or immediate
	private String action;

	@ManyToOne
	private User client;

	// date echeance
	private Date deadline;

	@ManyToOne
	private Account account;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumcarte() {
		return cardNumber;
	}

	public void setNumcarte(int numcarte) {
		this.cardNumber = numcarte;
	}

	public Integer getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	public Long getCeiling() {
		return ceiling;
	}

	public void setCeiling(Long ceiling) {
		this.ceiling = ceiling;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
