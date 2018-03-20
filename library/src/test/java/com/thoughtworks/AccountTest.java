package com.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AccountTest {

    private Account account;

    @Before
    public void setUp() throws MinimumExceptionError {
        account = new Account("1234", 1000);
    }

    @Test
    public void shouldCheckBalance() {
        float balance  = 1000.0f;
        assertThat(account.getBalance(),is(balance));
    }



    @Test(expected = MinimumExceptionError.class)
    public void shouldCheckForMinimumBalance() throws MinimumExceptionError {
        new Account("2345",200);
    }
}