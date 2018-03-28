package com.vim.sample.axon.bank.axonbank.coreapi;

public class AccountCreatedEvent {
	
private String accountId;
	
	private int overdraftLimit;

	public AccountCreatedEvent(String accountId, int overdraftLimit) {
		super();
		this.accountId = accountId;
		this.overdraftLimit = overdraftLimit;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public int getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(int overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}

}
