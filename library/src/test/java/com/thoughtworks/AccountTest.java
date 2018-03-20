package com.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AccountTest {

    private Account account1;

    @Before
    public void setUp() throws MinimumBalanceException, InvalidAccountNumberException {
        account1 = new Account("1234-2345", 1000);
    }

    @Test
    public void shouldCheckBalance() {
        float balance  = 1000.0f;
        assertThat(account1.getBalance(),is(balance));
        assertThat(account1.getBalance(),is(balance));
    }

    @Test(expected = MinimumBalanceException.class)
    public void shouldCheckForMinimumBalance() throws MinimumBalanceException, InvalidAccountNumberException {
        new Account("2345-3232",200);
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void shouldValidateAccountNumber() throws MinimumBalanceException, InvalidAccountNumberException {
       new Account("1234",1000);
    }

    @Test
    public void shouldDebitAmountFromAccount() throws InvalidAccountNumberException, MinimumBalanceException {
        Account account=new Account("2345-7890",1000);
        account.debit(200.0f);
        assertThat(account.getBalance(),is(800.0f));
    }

    @Test (expected = MinimumBalanceException.class)
    public void shouldDebitUptoMinimumBalance() throws MinimumBalanceException {
       account1.debit(860);
    }

    @Test
    public void shouldCreditAmountInAccount() throws MinimumBalanceException, InvalidAccountNumberException {
        Account account=new Account("1234-2121",1000);
        account.credit(300);
        assertThat(account.getBalance(),is(1300.0f));
    }
}