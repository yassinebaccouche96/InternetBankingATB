package com.internetBankingATB.models;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {

	@Id
	@GeneratedValue
	private Long id;

	// FIXME do Enum
	private String transactionType;

	private Date transactionDate;

	private Double amount;

	@ManyToOne
	private Account accountSender;

	@ManyToOne
	private Account accountReceiver;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Account getAccountSender() {
		return accountSender;
	}

	public void setAccountSender(Account accountSender) {
		this.accountSender = accountSender;
	}

	public Account getAccountReceiver() {
		return accountReceiver;
	}

	public void setAccountReceiver(Account accountReceiver) {
		this.accountReceiver = accountReceiver;
	}

	public List<Transaction> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Transaction> findByid(Long id2) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Transaction transaction) {
		// TODO Auto-generated method stub
		
	}

	 public void save(Transaction transaction) {
		// TODO Auto-generated method stub
		
	}

	

}
