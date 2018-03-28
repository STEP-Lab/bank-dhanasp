package com.thoughtworks;

import com.thoughtworks.exception.InvalidAccountNumberException;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DebitTransactionTest {

    private Transaction debitedTo;

    @Before
    public void setUp() throws Exception {
        debitedTo=new DebitTransaction(100,new AccountNumber("1234-1231"));
    }

    @Test
    public void shouldReturnTransactionInfoWithType() {
        String expected=new Date().toString()+",1234-1231,100.0,debit";
        assertThat(debitedTo.toCSV(),is(expected));

    }
}
