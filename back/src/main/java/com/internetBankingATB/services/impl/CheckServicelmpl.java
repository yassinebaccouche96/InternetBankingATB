package com.internetBankingATB.services.impl;

import java.util.List;
//import java.util.Optional;

import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

//import com.internetBankingATB.models.Card;
//import com.internetBankingATB.models.Checks;
import com.internetBankingATB.repositories.CheckRepository;
import com.internetBankingATB.services.CheckService;

@Service
public class CheckServicelmpl implements CheckService {

	@Autowired
	private CheckRepository checkRepository;

	@Override
	public void addCheck(Check check) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCheck(Check check) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Check getCheckBycheckNumber(Integer checkNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Check> getChecks() {
		// TODO Auto-generated method stub
		return null;
	}



}
