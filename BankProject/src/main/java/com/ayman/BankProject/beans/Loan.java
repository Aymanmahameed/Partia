package com.ayman.BankProject.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "loans")
public class Loan {
	
	@Id
	@Column(name = "loan_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer loanId;
	
	@Column(name = "amount")
	private float amount;
	
	@Column(name = "Interest_rate")
	private float InterestRate; 
	
	@Column(name = "monthly_payment")
	private float monthlyPayment ;
	
	@Column(name = "cuurent_balance")
	private float cuurentBalance;
	
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public Loan() {
		super();
	}

	public Loan(float amount, float interestRate, float monthlyPayment, float cuurentBalance) {
		super();
		this.amount = amount;
		InterestRate = interestRate;
		this.monthlyPayment = monthlyPayment;
		this.cuurentBalance = cuurentBalance;
	}

	public Integer getLoadId() {
		return loanId;
	}

	public void setLoadId(Integer loadId) {
		this.loanId = loadId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getInterestRate() {
		return InterestRate;
	}

	public void setInterestRate(float interestRate) {
		InterestRate = interestRate;
	}

	public float getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(float monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	public float getCuurentBalance() {
		return cuurentBalance;
	}

	public void setCuurentBalance(float cuurentBalance) {
		this.cuurentBalance = cuurentBalance;
	}

	@Override
	public String toString() {
		return "Loan [loadId=" + loanId + ", amount=" + amount + ", InterestRate=" + InterestRate + ", monthlyPayment="
				+ monthlyPayment + ", cuurentBalance=" + cuurentBalance + "]";
	} 
	
	
}
