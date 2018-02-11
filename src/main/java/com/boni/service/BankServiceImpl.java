package com.boni.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boni.dao.BankRepository;
import com.boni.model.BankDetails;

@Service
public class BankServiceImpl implements BankService{

	@Autowired
	private BankRepository bankRepo;
	
	@Override
	public String getBankNameByBankIdentifier(long id) {
		List<BankDetails> bankIdentifierList = bankRepo.getBankNameByBankIdentifier(id);
		String bankName = bankIdentifierList!=null && !bankIdentifierList.isEmpty()?bankIdentifierList.get(0).getBankName():"";
		System.out.println(bankName);
		return bankName;
	}

}
