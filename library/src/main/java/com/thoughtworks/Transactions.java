package com.thoughtworks;

import java.util.ArrayList;

public class Transactions {
    protected final ArrayList<Transaction> allTransactions;


    public Transactions() {
        this.allTransactions =new ArrayList<>();
    }

    public void debit(float amount, AccountNumber to) {
        this.allTransactions.add(new DebitTransaction(amount,to));
    }

    public ArrayList<Transaction> getAllTransactions() {
        return allTransactions;
    }



}
