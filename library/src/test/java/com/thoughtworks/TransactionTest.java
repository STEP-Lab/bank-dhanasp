package com.thoughtworks;

import com.thoughtworks.exception.InvalidAccountNumberException;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransactionTest {
    @Test
    public void checkDateOfTransaction() throws InvalidAccountNumberException {
        Date date = new Date();
        String dateInString=date.toString();
        Transaction transaction= new DebitTransaction(new Date(), 100,new AccountNumber("1223-2345"));
        assertThat(transaction.getDate().toString(),is(dateInString));
    }


}
