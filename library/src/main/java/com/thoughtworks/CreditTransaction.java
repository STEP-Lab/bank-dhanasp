package com.thoughtworks;

import java.util.Date;

public class CreditTransaction extends Transaction {

    protected CreditTransaction(Date date, double amount, AccountNumber to) {
        super(date, amount, to);

    }

    public CreditTransaction(double amount, AccountNumber to) {
        this(new Date(),amount,to);
    }

    @Override
    public String toCSV() {
        return super.toCSV()+","+"credit";
    }
}
