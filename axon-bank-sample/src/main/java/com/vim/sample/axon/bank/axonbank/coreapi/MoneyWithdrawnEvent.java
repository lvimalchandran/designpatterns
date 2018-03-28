package com.vim.sample.axon.bank.axonbank.coreapi;

public class MoneyWithdrawnEvent {
		
	private String accountId;
	private int amount;
	private int balance;
	
	public MoneyWithdrawnEvent(String accountId, int amount, int balance) {
		super();
		this.accountId = accountId;
		this.amount = amount;
		this.balance = balance;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

	
}
