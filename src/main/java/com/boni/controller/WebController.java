package com.boni.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boni.service.BankService;

@RestController
public class WebController {
	
	private static final Logger logger = LoggerFactory.getLogger(WebController.class);
	
	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job job;

	@Autowired
	private BankService bankService;
	
	@RequestMapping("/startProcess")
	public String startProcess() throws Exception {
		
		try {
			JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
					.toJobParameters();
			jobLauncher.run(job, jobParameters);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "CSV Processing done!!!!!!!";
	}
	
	@RequestMapping("/bank_identifier/{identifier}")
	public String handle(@PathVariable("identifier") long id) throws Exception {
		return bankService.getBankNameByBankIdentifier(id);
	}
}

