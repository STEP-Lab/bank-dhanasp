package com.thoughtworks;

import com.thoughtworks.exception.InvalidAccountNumberException;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;

public class TransactionsTest {
    private Transactions transactions;
    private Transactions resultedTransactions;
    private Transactions resultedTransactions1;
    private Calendar calendar;

    @Before
    public void setUp(){
        transactions =new Transactions();
        resultedTransactions = new Transactions();
        calendar=Calendar.getInstance();
    }

    @Test
    public void addDebitTransactions() throws InvalidAccountNumberException {
        AccountNumber to=new AccountNumber("1235-1234");
        transactions.debit(1000,to);
        assertThat(transactions.allTransactions,hasItem(new DebitTransaction(new Date(),1000,new AccountNumber("1235-1234"))));
    }
    @Test
    public void addCreditTransactions() throws InvalidAccountNumberException {
        Transactions transactions=new Transactions();
        AccountNumber to=new AccountNumber("1235-1234");
        transactions.credit(1000,to);
        assertThat(transactions.allTransactions,hasItem(new CreditTransaction(new Date(),1000,new AccountNumber("1235-1234"))));
    }

    @Test
    public void shouldAddAllTypesOfTransaction() throws InvalidAccountNumberException {
        DebitTransaction debitTransaction = new DebitTransaction(new Date(), 200, new AccountNumber("1235-1234"));
        CreditTransaction creditTransaction = new CreditTransaction(new Date(), 1000, new AccountNumber("1235-1234"));
        Transactions transactions=new Transactions();
        AccountNumber to=new AccountNumber("1235-1234");
        transactions.credit(1000,to);
        transactions.debit(200,to);
        assertThat(transactions.allTransactions,hasItems(debitTransaction,creditTransaction));

    }

    @Test
    public void shouldFilterTransactionsByAmount() throws InvalidAccountNumberException {
        transactions.credit(1000,new AccountNumber("1234-3456"));
        transactions.credit(1500,new AccountNumber("1234-3456"));
        transactions.debit(200,new AccountNumber("1234-3456"));
        CreditTransaction creditTransaction=new CreditTransaction(new Date(), 1000,new AccountNumber("1234-3456"));
        DebitTransaction debitTransaction=new DebitTransaction(new Date(), 200,new AccountNumber("1234-3456"));
        CreditTransaction creditTransaction2=new CreditTransaction(new Date(), 1500,new AccountNumber("4534-2342"));
        resultedTransactions = transactions.filterByAmountGreaterThan(1000);
        assertThat(transactions.allTransactions,hasItems(creditTransaction,debitTransaction));

    }

    @Test
    public void shouldReturnCreditTransaction() throws InvalidAccountNumberException {
        transactions.credit(1000,new AccountNumber("1234-3456"));
        transactions.credit(1500,new AccountNumber("4534-2342"));
        transactions.debit(200,new AccountNumber("2345-1231"));
        CreditTransaction creditTransaction=new CreditTransaction(new Date(), 1000,new AccountNumber("1234-3456"));
        CreditTransaction creditTransaction2=new CreditTransaction(new Date(), 1500,new AccountNumber("4534-2342"));
        resultedTransactions = transactions.getCreditTransactions();
        assertThat(resultedTransactions.allTransactions,hasItems(creditTransaction,creditTransaction2));

    }

    @Test
    public void shouldReturnDebitTransaction() throws InvalidAccountNumberException {
        transactions.credit(1000,new AccountNumber("1234-1234"));
        transactions.debit(100,new AccountNumber("1234-5432"));
        transactions.debit(200,new AccountNumber("5647-1234"));
        DebitTransaction debitTransaction=new DebitTransaction(new Date(),100,new AccountNumber("1234-5432"));
        DebitTransaction debitTransaction1=new DebitTransaction(new Date(),200,new AccountNumber("5647-1234"));
        resultedTransactions= transactions.getDebitTransactions();
        assertThat(resultedTransactions.allTransactions,hasItems(debitTransaction,debitTransaction1));
    }



    @Test
    public void shouldPrintTransactions () throws InvalidAccountNumberException, FileNotFoundException, UnsupportedEncodingException {
        
        ArrayList<String> result=new ArrayList<>();
        
        Transactions transactions1 = new Transactions();
        transactions1.credit(1000,new AccountNumber("1234-2345"));
        transactions1.debit(100,new AccountNumber("1234-5768"));
        CreditTransaction creditTransaction=new CreditTransaction(new Date(), 1000,new AccountNumber("1234-2345"));
        DebitTransaction debitTransaction=new DebitTransaction(new Date(), 100,new AccountNumber("1234-5768"));
        PrintWriter printWriter = new PrintWriter("transactionSummary.txt","UTF-8"){
            @Override
            public void println(String x) {
                result.add(x);
            }
        };
        transactions1.print(printWriter);
        printWriter.close();
        assertThat(result,hasItems(creditTransaction.toString(),debitTransaction.toString()));
    }

}
