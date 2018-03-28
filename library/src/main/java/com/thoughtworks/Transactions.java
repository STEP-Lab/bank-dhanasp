package com.thoughtworks;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Transactions {
    protected final ArrayList<Transaction> allTransactions;

    public Transactions() {
        this.allTransactions =new ArrayList<>();
    }

    public void debit(double amount, AccountNumber to) {
        this.allTransactions.add(new DebitTransaction(new Date(), amount,to));
    }

    public ArrayList<Transaction> getAllTransactions() {
        return allTransactions;
    }

    public void credit(double amount, AccountNumber to) {
        this.allTransactions.add(new CreditTransaction(new Date(), amount,to));
    }

    public Transactions filterByAmountGreaterThan(int amount) {
        Transactions filteredTransactions = new Transactions();
        for (Transaction transaction:allTransactions){
            if (transaction.getAmount()>=amount){
                filteredTransactions.allTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }

    public void print(PrintWriter printWriter) {
        for (Transaction transaction:allTransactions){
            printWriter.write(transaction.toString());
        }
    }

    public Transactions getCreditTransactions() {
        Transactions creditTransactions=new Transactions();
        for (Transaction transaction:allTransactions){
            if (transaction instanceof CreditTransaction){
                creditTransactions.allTransactions.add(transaction);
            }
        }
        return creditTransactions;
    }

    public Transactions getDebitTransactions() {
        Transactions debitTransactions=new Transactions();
        for (Transaction transaction:allTransactions){
            if (transaction instanceof DebitTransaction){
                debitTransactions.allTransactions.add(transaction);
            }
        }
        return debitTransactions;
    }

    public void printToCSVFile(PrintWriter printWriter, String[] columnNames) throws IOException {
        CSVPrinter csvPrinter=new CSVPrinter(printWriter,columnNames);
        csvPrinter.print(allTransactions);
        csvPrinter.close();
    }
}
