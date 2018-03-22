package com.thoughtworks;

import java.util.Date;

public class DebitTransaction extends Transaction{
    protected DebitTransaction(Date date, float amount, AccountNumber To) {
        super(date,amount,To);
    }

    public DebitTransaction(float amount, AccountNumber To) {
        this(new Date(),amount,To);
    }
}
