package com.thoughtworks;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class CSVPrinter implements Printer {
    private PrintWriter writer;
    private String[] headers;

    public CSVPrinter(PrintWriter writer, String[] headers) throws IOException {
        this.writer = writer;
        this.headers = headers;
        writer.println(String.join(",",headers));
    }

    @Override
    public void print(Transaction transaction) throws IOException {
        writer.println(transaction.toCSV());
    }
    @Override
    public void print(ArrayList<Transaction> allTransactions) throws IOException {
        for (Transaction transaction:allTransactions){
            writer.println(transaction.toCSV());
        }
    }



    public void close(){
        writer.flush();
        writer.close();
    }

}
