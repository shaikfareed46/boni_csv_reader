package com.boni.batch.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.boni.model.BankDetails;

public class Processor implements ItemProcessor<BankDetails, BankDetails> {

	private static final Logger log = LoggerFactory.getLogger(Processor.class);

	@Override
	public BankDetails process(BankDetails bankIdentifier) throws Exception {
		log.info("Processing the bank identifier: "+bankIdentifier.getBankName());
		return bankIdentifier;
	}
}
