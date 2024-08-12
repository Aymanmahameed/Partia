package com.ayman.BankProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayman.BankProject.beans.Currency;

@Repository
public interface CurrencyDAO extends JpaRepository<Currency, Integer> {
	
	Currency findCurrencyByCurrencyId(Integer id);

}
