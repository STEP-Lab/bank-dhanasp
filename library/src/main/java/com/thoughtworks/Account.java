package com.thoughtworks;


import com.thoughtworks.exception.InvalidAccountNumberException;
import com.thoughtworks.exception.InvalidCreditAmountException;
import com.thoughtworks.exception.InvalidDebitAmountException;
import com.thoughtworks.exception.MinimumBalanceException;

import java.util.Date;

public class Account {
    private final String accountNumber;
    private static final float minimumBalance=200;
    private float balance;
    public Account(String accountNumber, float balance) throws MinimumBalanceException, InvalidAccountNumberException {
        this.balance=balance;
        this.accountNumber=accountNumber;
    }
    public static Account create(String accountNumber, float balance) throws MinimumBalanceException, InvalidAccountNumberException {
        validate(accountNumber,balance);
        return new Account(accountNumber,balance);
    }

    public float getBalance() {
        return balance;
    }
    private static void validate(String accountNumber, float balance) throws InvalidAccountNumberException, MinimumBalanceException {
        validateAccountNumber(accountNumber);
        validateBalance(balance);
    }

    private static void validateBalance(float balance) throws MinimumBalanceException {
        if (balance<=minimumBalance){
            throw new MinimumBalanceException();
        }
    }

    private static void validateAccountNumber(String accountNumber) throws InvalidAccountNumberException {
        boolean match=accountNumber.matches("\\d{4}-\\d{4}");
        if (!match){
            throw new InvalidAccountNumberException();
        }
    }


    public float debit(float amountCanDebited) throws InvalidDebitAmountException {
        if (canDebit(amountCanDebited)){
            balance= balance - amountCanDebited;
            return balance;
        }
        throw new InvalidDebitAmountException();
    }

    private boolean canDebit(float amountCanDebited) {
        float remaining_balance=balance - amountCanDebited;
        return remaining_balance>=minimumBalance;
    }

    public float credit(float amount) throws InvalidCreditAmountException {
        if (canCredit(amount)) {
            balance=balance+amount;
            return balance;
        }
        throw new InvalidCreditAmountException();
    }

    private boolean canCredit(float creditAmount) {
        return creditAmount>0;
    }

}
