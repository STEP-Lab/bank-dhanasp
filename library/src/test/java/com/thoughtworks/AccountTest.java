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
        account1 = Account.create("1234-2312", 1000);
    }

    @Test
    public void shouldCheckBalance() {
        float balance  = 1000;
        assertThat(account1.getBalance(),is(balance));
    }

    @Test(expected = MinimumBalanceException.class)
    public void shouldCheckForMinimumBalance() throws MinimumBalanceException, InvalidAccountNumberException {
        Account.create("1234-2112",100);
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void shouldValidateAccountNumber() throws MinimumBalanceException, InvalidAccountNumberException {
        Account.create("1234",1000);
    }

    @Test
    public void shouldDebitAmountFromAccount() throws InvalidAccountNumberException, MinimumBalanceException, InvalidDebitAmountException {
        Account account=new Account("2345-7890",1000);
        account.debit(200.0f);
        assertThat(account.getBalance(),is(800.0f));
    }


    @Test (expected = InvalidDebitAmountException.class)
    public void shouldDebitUptoMinimumBalance() throws InvalidDebitAmountException {
       account1.debit(860.0f);
    }

    @Test
    public void shouldCreditAmountInAccount() throws MinimumBalanceException, InvalidAccountNumberException, InvalidCreditAmountException {
        Account account=Account.create("1234-2112",1000);
        account.credit(300);
        assertThat(account.getBalance(),is(1300.0f));
    }

    @Test
    public void shouldCheckCreditAmount() throws InvalidCreditAmountException {
        account1.credit(account1.getBalance()-1);
    }
}