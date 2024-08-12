package com.ayman.BankProject.beans;

import java.sql.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="transaction_id")
	private Integer transactionId;
	
	@Column(name ="tran_number")
	private String tranNumber;
	
	@Column(name = "transaction_date")
	private Date transactionDate;
	
	@Column(name = "amount")
	private float amount;
	
	@Column(name = "transactions_type")
	@Enumerated(EnumType.STRING)
	private TransactionType transactionsType;
	
	
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;
	
	@ManyToOne
	@JoinColumn(name = "currency_id")
	private Currency currency;
	
	

	public Transaction() {
		super();
	}

	
	
	public Transaction(Integer transactionId, String tranNumber, Date transactionDate, float amount,
			TransactionType transactionsType, Account account, Currency currency) {
		super();
		this.transactionId = transactionId;
		this.tranNumber = tranNumber;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.transactionsType = transactionsType;
		this.account = account;
		this.currency = currency;
	}



	public Transaction(String tranNumber, Date transactionDate, float amount, TransactionType transactionsType) {
		super();
		this.tranNumber = tranNumber;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.transactionsType = transactionsType;
	}



	public Transaction(Date transactionDate, float amount, TransactionType transactionsType) {
		super();
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.transactionsType = transactionsType;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public TransactionType getTransactionsType() {
		return transactionsType;
	}

	public void setTransactionsType(TransactionType transactionsType) {
		this.transactionsType = transactionsType;
	}

	
	
	
	public String getTranNumber() {
		return tranNumber;
	}



	public void setTranNumber(String tranNumber) {
		this.tranNumber = tranNumber;
	}



	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", tranNumber=" + tranNumber + ", transactionDate="
				+ transactionDate + ", amount=" + amount + ", transactionsType=" + transactionsType + ", account="
				+ account + ", currency=" + currency + "]";
	}
	
	
	
	
	
	
}
