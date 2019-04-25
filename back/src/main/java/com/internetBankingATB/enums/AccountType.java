package com.internetBankingATB.enums;

import java.util.Arrays;

public enum AccountType {

	current_account(1, "current_account"), savings_account(2, "savings_account"),

	tourist_allowance_account(3, "tourist_allowance_account");

	private Integer id;
	private String description;

	private AccountType(Integer id, String description) {
		this.id = id;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AccountType getTypeById(Integer idAccount) {

		Arrays.asList(values()).stream().filter(AccountType -> AccountType.getId().equals(idAccount)).findFirst().get();

		return null;
	}
}
