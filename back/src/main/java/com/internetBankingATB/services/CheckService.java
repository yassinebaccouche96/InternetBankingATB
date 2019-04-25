package com.internetBankingATB.services;

import java.util.List;

import org.hibernate.annotations.Check;






public interface CheckService {

	void addCheck(Check check);
	void deleteCheck(Check check);
	Check getCheckBycheckNumber(Integer checkNumber);
	List<Check> getChecks();
	

}
