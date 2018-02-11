package com.boni.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.boni.dao.BankRepository;
import com.boni.model.BankDetails;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public BankRepository customerDao;

	@Bean
	public Job job() {
		return jobBuilderFactory.get("job").incrementer(new RunIdIncrementer()).listener(new Listener(customerDao))
				.flow(step1()).end().build();
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<BankDetails, BankDetails>chunk(2)
				.reader(Reader.reader("bank-data.csv"))
				.processor(new Processor()).writer(new Writer(customerDao)).build();
	}
	
}
