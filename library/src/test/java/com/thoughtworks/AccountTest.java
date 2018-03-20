package com.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AccountTest {

    private Account account1;

    @Before
    public void setUp() throws MinimumExceptionError, InvalidAccountNumberException {
        account1 = new Account("1234-2345", 1000);
    }

    @Test
    public void shouldCheckBalance() {
        float balance  = 1000.0f;
        assertThat(account1.getBalance(),is(balance));
    }

    @Test(expected = MinimumExceptionError.class)
    public void shouldCheckForMinimumBalance() throws MinimumExceptionError, InvalidAccountNumberException {
        new Account("2345-3232",200);
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void shouldValidateAccountNumber() throws MinimumExceptionError, InvalidAccountNumberException {
       new Account("1234",1000);
    }

    @Test
    public void shouldDebitAmountFromAccount() {
        assertThat(account1.debit(100),is(900.0f));
    }

}