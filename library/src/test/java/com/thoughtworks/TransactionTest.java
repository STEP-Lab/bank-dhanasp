package com.thoughtworks;

import com.thoughtworks.exception.InvalidAccountNumberException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransactionTest {

    private Transaction transaction;

    @Before
    public void setUp() throws Exception {
        transaction = new DebitTransaction(new Date(), 100,new AccountNumber("1223-2345"));
    }

    @Test
    public void checkDateOfTransaction() throws InvalidAccountNumberException {
        Date date = new Date();
        String dateInString=date.toString();
        assertThat(transaction.getDate().toString(),is(dateInString));
    }

    @Test
    public void shouldReturnArrayOfWholeTransaction() {
        String expected=new Date().toString()+",1223-2345,100.0";
        assertThat(transaction.toCSV(),is(expected));
    }
}
