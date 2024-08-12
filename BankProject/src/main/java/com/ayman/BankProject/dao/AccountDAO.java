package com.ayman.BankProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayman.BankProject.beans.Account;

@Repository
public interface AccountDAO extends JpaRepository<Account, Integer>{
	
	Account findAcoountByAccountId(Integer id);

}
