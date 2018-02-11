package com.boni.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BANK_DETAILS")
public class BankDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="bank_id")
	private Long bankId;
	
	@Column(name = "bank_name")
	private String bankName;
	
	@Column(name = "bank_identifier")
	private Long bankIdentifier;

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Long getBankIdentifier() {
		return bankIdentifier;
	}

	public void setBankIdentifier(Long bankIdentifier) {
		this.bankIdentifier = bankIdentifier;
	}
	
	
}
