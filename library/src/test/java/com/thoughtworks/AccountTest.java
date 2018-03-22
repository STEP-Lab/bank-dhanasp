package com.thoughtworks;

import com.thoughtworks.exception.InvalidAccountNumberException;
import com.thoughtworks.exception.InvalidCreditAmountException;
import com.thoughtworks.exception.InvalidDebitAmountException;
import com.thoughtworks.exception.MinimumBalanceException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AccountTest {

    private Account account1;

    @Before
    public void setUp() throws Exception {
        account1 = new Account(new AccountNumber("1234-2345"),1000);
    }

    @Test
    public void shouldCheckBalance() {
        float balance  = 1000;
        assertThat(account1.getBalance(),is(balance));
    }

    @Test(expected = MinimumBalanceException.class)
    public void shouldCheckForMinimumBalance() throws MinimumBalanceException, InvalidAccountNumberException {
        Account account = new Account(new AccountNumber("1234-2345"),100);

    }

    @Test
    public void shouldDebitAmountFromAccount() throws MinimumBalanceException, InvalidDebitAmountException, InvalidAccountNumberException {
        Account account=new Account(new AccountNumber("2345-7890"),1000);
        account.debit(200.0f);
        assertThat(account.getBalance(),is(800.0f));
    }


    @Test (expected = InvalidDebitAmountException.class)
    public void shouldDebitUptoMinimumBalance() throws InvalidDebitAmountException, InvalidAccountNumberException, MinimumBalanceException {
        Account account=new Account(new AccountNumber("2345-7890"),1000);
        account1.debit(860.0f);
    }

    @Test
    public void shouldCreditAmountInAccount() throws MinimumBalanceException, InvalidAccountNumberException, InvalidCreditAmountException {
        Account account=new Account(new AccountNumber("2345-7890"),1000);
        account.credit(300);
        assertThat(account.getBalance(),is(1300.0f));
    }

    @Test
    public void shouldCheckCreditAmount() throws InvalidCreditAmountException {
        account1.credit(account1.getBalance()-1);
    }
}