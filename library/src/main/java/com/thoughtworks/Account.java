package com.thoughtworks;

public class Account {
    private final String accountNumber;
    private final float balance;

    public Account(String accountNumber, float balance) throws MinimumExceptionError {
        this.accountNumber = accountNumber;
        if (balance<=200){
            throw new MinimumExceptionError();
        }
        this.balance = balance;
    }

    public float getBalance() {
        return balance;
    }
}
