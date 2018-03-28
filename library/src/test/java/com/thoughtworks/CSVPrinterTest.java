package com.thoughtworks;

import com.thoughtworks.exception.InvalidAccountNumberException;
import org.junit.Before;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CSVPrinterTest {
    private CSVPrinter csvPrinter;
    private String[] columnNames;
    private PrintWriter writer;

    @Before
    public void setUp() throws Exception {
        columnNames=new String[]{"date","source","amount","type Of transaction"};
        writer =new PrintWriter("foo.csv");
        csvPrinter= new CSVPrinter(writer,columnNames);
    }

    @Test
    public void shouldWriteTransactionInfo() throws IOException, InvalidAccountNumberException {
        Transaction transaction=new CreditTransaction(1000,new AccountNumber("1234-1234"));
        Transaction newTransaction=new DebitTransaction(200,new AccountNumber("1234-2334"));

        ArrayList<String> result=new ArrayList<>();
        PrintWriter writer1=new PrintWriter("transactionINFO.csv","UTF8"){
            @Override
            public void println(String x) {
                result.add(x);
            }
        };
        CSVPrinter csvPrinter1=new CSVPrinter(writer1,columnNames);
        csvPrinter1.print(transaction);
        csvPrinter1.print(newTransaction);
        csvPrinter1.close();
        String expected="date,source,amount,type Of transaction\n" + new Date().toString()+
                ",1234-1234,1000.0,credit\n"+new Date().toString()+",1234-2334,200.0,debit";
        assertThat(String.join("\n",result),is(expected));
    }

    @Test
    public void shouldPrintAllTransactions() throws IOException, InvalidAccountNumberException {
        Transactions transactions=new Transactions();
        transactions.debit(1000,new AccountNumber("1234-1234"));
        transactions.credit(100,new AccountNumber("1234-1224"));
        ArrayList<String> result=new ArrayList<>();
        PrintWriter writer1=new PrintWriter("transactionINFO.csv","UTF8"){
            @Override
            public void println(String x) {
                result.add(x);
            }
        };
        CSVPrinter csvPrinter1=new CSVPrinter(writer1,columnNames);
        csvPrinter1.print(transactions.allTransactions);
        csvPrinter1.close();
        String expected="date,source,amount,type Of transaction\n" + new Date().toString()+
                ",1234-1234,1000.0,debit\n"+new Date().toString()+",1234-1224,100.0,credit";
        assertThat(String.join("\n",result),is(expected));



    }
}
