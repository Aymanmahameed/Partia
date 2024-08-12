package com.ayman.BankProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayman.BankProject.beans.Transaction;

@Repository
public interface TransactionDAO extends JpaRepository<Transaction, Integer> {
	
	
	Transaction findTransactionByTransactionId(Integer id);

}
