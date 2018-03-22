package com.thoughtworks;

import com.thoughtworks.DebitTransaction;
import com.thoughtworks.exception.InvalidAccountNumberException;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransactionTest {
    @Test
    public void checkDateOfTransaction() throws InvalidAccountNumberException {
        Date date = new Date();
       Transaction transaction= new DebitTransaction(date,100,new AccountNumber("1223-2345"));
        assertThat(transaction.getDate(),is(date));
    }


}
