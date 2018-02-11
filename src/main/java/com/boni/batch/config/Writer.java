package com.boni.batch.config;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.boni.dao.BankRepository;
import com.boni.model.BankDetails;

public class Writer implements ItemWriter<BankDetails> {

	private final BankRepository bankDao;

	public Writer(BankRepository customerDao) {
		this.bankDao = customerDao;
	}

	@Override
	public void write(List<? extends BankDetails> banksList) throws Exception {
		bankDao.save(banksList);
	}

}
