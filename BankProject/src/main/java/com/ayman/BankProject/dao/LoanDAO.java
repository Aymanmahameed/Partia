package com.ayman.BankProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayman.BankProject.beans.Loan;

@Repository
public interface LoanDAO extends JpaRepository<Loan, Integer>{
	
	Loan findLoanByLoanId(Integer id);

}
