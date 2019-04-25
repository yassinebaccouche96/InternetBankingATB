package com.internetBankingATB.enums;

import java.util.Arrays;

public enum CardType {

	CARD_TECKNOLOGIC_ATB(1, "Card technologic atb"), CARD_ATB_LELA(2, "card atb lele"),
	CARD_MOUSSAFIR_PLATINUIM(3, "card moussafir platnuim"), CARD_EL_KHIR(4, "card el khir"),
	CARD_ATB_MASTER(5, "master card"), CARD_ATB_VISA_GOLD(6, "visa card"), CARD_C_JEUNE(7, "c jeune card"),
	CARD_AMEX(8, "amex card"), CARD_MASTER_WORLD(9, "master world card");

	private Integer id;
	private String description;

	private CardType(Integer id, String description) {
		this.id = id;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public CardType getTypeById(Integer idCard) {

		Arrays.asList(values()).stream().filter(CardType -> CardType.getId().equals(idCard)).findFirst().get();

		return null;
	}

}
