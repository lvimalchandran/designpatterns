package com.vim.sample.axon.bank.axonbank.account;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import com.vim.sample.axon.bank.axonbank.OverDraftExceededException;
import com.vim.sample.axon.bank.axonbank.coreapi.AccountCreatedEvent;
import com.vim.sample.axon.bank.axonbank.coreapi.CreateAccountCommand;
import com.vim.sample.axon.bank.axonbank.coreapi.MoneyWithdrawnEvent;
import com.vim.sample.axon.bank.axonbank.coreapi.WithdrawMoneyCommand;


public class Account {

	public Account() {
		super();
	}

	@AggregateIdentifier
	private String accountId;
	
	private int overdraftLimit;

	private int balance;
	
	@CommandHandler
	public Account(CreateAccountCommand accountCommand) {
		apply(new AccountCreatedEvent(accountCommand.getAccountId(), accountCommand.getOverdraftLimit()));
	}

	@CommandHandler
	public void handler(WithdrawMoneyCommand withdrawMoneyCommand) throws OverDraftExceededException {
		if (balance + overdraftLimit >= withdrawMoneyCommand.getAmount()) {
			apply(new MoneyWithdrawnEvent(withdrawMoneyCommand.getAccountId(), withdrawMoneyCommand.getAmount(), balance - withdrawMoneyCommand.getAmount()));
		} else {
			throw new OverDraftExceededException();
		}
	}
	
	@EventSourcingHandler
	public void on(MoneyWithdrawnEvent event) {
		this.balance = event.getBalance();
	}
	
	@EventSourcingHandler
	public void on(AccountCreatedEvent event) {
		this.accountId = event.getAccountId();
		this.overdraftLimit = event.getOverdraftLimit();
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
