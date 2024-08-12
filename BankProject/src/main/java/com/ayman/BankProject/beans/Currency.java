package com.ayman.BankProject.beans;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "currencies")
public class Currency {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "currency_id")
	private Integer currencyId;
	
	@Column(name = "name")
	private String name ;
	
	@Column(name = "exchange_rate")
	private float exchangeRate;
	
	
	
	@OneToMany(mappedBy = "currency")
	private List<Transaction> transactions;

	public Currency() {
		super();
	}

	public Currency(String name, float exchangeRate) {
		super();
		this.name = name;
		this.exchangeRate = exchangeRate;
	}

	public Integer getCurrencyID() {
		return currencyId;
	}

	public void setCurrencyID(Integer currencyID) {
		this.currencyId = currencyID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(float exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	@Override
	public String toString() {
		return "Currency [currencyID=" + currencyId + ", name=" + name + ", exchangeRate=" + exchangeRate + "]";
	} 
	
	

}
