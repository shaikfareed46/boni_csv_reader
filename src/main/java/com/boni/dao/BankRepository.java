package com.boni.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boni.model.BankDetails;

@Repository
public interface BankRepository extends JpaRepository<BankDetails, Serializable>{

	List<BankDetails> getBankNameByBankIdentifier(long id);

}
