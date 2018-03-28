package com.vim.sample.axon.bank.axonbank.coreapi;

public class CreateAccountCommand {
		
	private String accountId;
	
	private int overdraftLimit;

	public CreateAccountCommand(String accountId, int overdraftLimit) {
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
