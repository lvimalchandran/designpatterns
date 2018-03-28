package com.vim.sample.axon.bank.axonbank;

import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;

import com.vim.sample.axon.bank.axonbank.account.Account;
import com.vim.sample.axon.bank.axonbank.coreapi.AccountCreatedEvent;
import com.vim.sample.axon.bank.axonbank.coreapi.CreateAccountCommand;
import com.vim.sample.axon.bank.axonbank.coreapi.MoneyWithdrawnEvent;
import com.vim.sample.axon.bank.axonbank.coreapi.WithdrawMoneyCommand;

public class AccountTest {

	private FixtureConfiguration<Account> fixture;

	@Before
	public void setUp() throws Exception {
		fixture = Fixtures.newGivenWhenThenFixture(Account.class);
	}
	
	@Test
	public void createAccount() throws Exception {
		fixture.givenNoPriorActivity()
				.when(new CreateAccountCommand("1234", 1000))
				.expectEvents(new AccountCreatedEvent("1234", 1000));
		
	}

	@Test
	public void withdrawReasonableAmount() throws Exception {
		fixture.given(new AccountCreatedEvent("1234", 1000))
				.when(new WithdrawMoneyCommand("1234", 600))
				.expectEvents(new MoneyWithdrawnEvent("1234", 600, -600));
	}

	@Test
	public void withdrawAbsurdAmount() throws Exception {
		fixture.given(new AccountCreatedEvent("1234", 1000))
				.when(new WithdrawMoneyCommand("1234", 1600))
				.expectNoEvents()
				.expectException(OverDraftExceededException.class);
	}
	
}
