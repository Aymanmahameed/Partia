package com.ayman.BankProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayman.BankProject.beans.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer,Integer> {
	
	Customer findCustomerByCustomerId(Integer id);
	

}
