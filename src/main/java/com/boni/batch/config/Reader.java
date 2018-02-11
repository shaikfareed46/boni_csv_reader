package com.boni.batch.config;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

import com.boni.model.BankDetails;


public class Reader {
	public static FlatFileItemReader<BankDetails> reader(String path) {
		FlatFileItemReader<BankDetails> reader = new FlatFileItemReader<BankDetails>();

		reader.setResource(new ClassPathResource(path));
		reader.setLineMapper(new DefaultLineMapper<BankDetails>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { "bankName", "bankIdentifier" });
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<BankDetails>() {
					{
						setTargetType(BankDetails.class);
					}
				});
			}
		});
		return reader;
	}
}
