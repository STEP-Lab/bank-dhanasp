package com.thoughtworks;

import com.thoughtworks.exception.InvalidAccountNumberException;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertThat;

public class TransactionsTest {
    @Test
    public void addDebitTransactions() throws InvalidAccountNumberException {
        Transactions transactions=new Transactions();
        AccountNumber to=new AccountNumber("1235-1234");
        transactions.debit(1000,to);
        assertThat(transactions.allTransactions,hasItem(new DebitTransaction(new Date(),1000,new AccountNumber("1235-1234"))));
    }
}
