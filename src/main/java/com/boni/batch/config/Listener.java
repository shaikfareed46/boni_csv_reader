package com.boni.batch.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

import com.boni.dao.BankRepository;
import com.boni.model.BankDetails;

public class Listener extends JobExecutionListenerSupport {
	private static final Logger log = LoggerFactory.getLogger(Listener.class);

	private final BankRepository customerDao;

	public Listener(BankRepository customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("Finish Job! Check the results");

			List<BankDetails> bankIdentifiers = customerDao.findAll();

			for (BankDetails bankIdentifier : bankIdentifiers) {
				log.info("Found <" + bankIdentifier.getBankName() + "> in the database.");
			}
		}
	}
}
