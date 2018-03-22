package com.thoughtworks;

import java.util.Date;

public class CreditTransaction extends Transaction {
    public CreditTransaction(Date date, float amount, AccountNumber to) {
        super(date, amount, to);
    }

    public CreditTransaction(float amount, AccountNumber to) {
        this(new Date(),amount,to);
    }
}
