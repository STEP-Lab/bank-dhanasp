package com.thoughtworks;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {

    @Test
    public void shouldCheckAccountBalance() {
        int initialBalance = 1000;
        Account account = new Account("1234", initialBalance);
        int actualBalance = account.getBalance();
        assertThat(actualBalance, is(initialBalance));
    }
}
