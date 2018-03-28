package com.vim.sample.axon.bank.axonbank.coreapi;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class WithdrawMoneyCommand {
	
	@TargetAggregateIdentifier
	private String accountId;
	
	private int amount;

	public WithdrawMoneyCommand(String accountId, int amount) {
		super();
		this.accountId = accountId;
		this.amount = amount;
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
	
	
}
