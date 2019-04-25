package com.internetBankingATB.enums;

import java.util.Arrays;

public enum CheckType {

	CHECK_TWENTY_CROSSED(1, "20 crossed check"), CHECK_TWENTY_NOT_CROSSED(2, "20 check not_crossed"),
	CHECK_FIFTY_CROSSED(3, "50 crossed check"), CHECK_FIFTY_NOT_CROSSED(4, "50 check not crossed");

	private Integer id;
	private String description;

	private CheckType(Integer id, String description) {
		this.id = id;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public CheckType getTypeById(Integer idCheck) {

		Arrays.asList(values()).stream().filter(CheckType -> CheckType.getId().equals(idCheck)).findFirst().get();

		return null;
	}
}
