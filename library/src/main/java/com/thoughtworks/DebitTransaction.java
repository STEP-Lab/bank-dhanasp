package com.thoughtworks;

import java.util.Date;

public class DebitTransaction extends Transaction{

    protected DebitTransaction(Date date, double amount, AccountNumber To) {
        super(date,amount,To);
    }

    public DebitTransaction(double amount, AccountNumber To) {
        this(new Date(),amount,To);
    }

    @Override
    public String toCSV() {
        return super.toCSV()+","+"debit";
    }
}
