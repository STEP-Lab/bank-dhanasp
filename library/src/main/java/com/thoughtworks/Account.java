package com.thoughtworks;


import com.thoughtworks.exception.InvalidCreditAmountException;
import com.thoughtworks.exception.InvalidDebitAmountException;
import com.thoughtworks.exception.MinimumBalanceException;

public class Account {
    private static float minimumBalance=200;
    private double balance;
    private AccountNumber accountNumber;

    public static Account create(AccountNumber accountNumber, double balance) throws MinimumBalanceException {
        validateBalance(balance);
        return new Account(accountNumber,balance);
    }

    public Account(AccountNumber accountNumber, double balance) throws MinimumBalanceException {
        this.accountNumber = accountNumber;
        this.balance=balance;

    }


    public double getBalance() {
        return balance;
    }

    private static void validateBalance(double balance) throws MinimumBalanceException {
        if (balance<=minimumBalance){
            throw new MinimumBalanceException();
        }
    }

    public double debit(double amountCanDebited) throws InvalidDebitAmountException {
        if (canDebit(amountCanDebited)){
            balance= balance - amountCanDebited;
            return balance;
        }
        throw new InvalidDebitAmountException();
    }

    private boolean canDebit(double amountCanDebited) {
        double remaining_balance=balance - amountCanDebited;
        return remaining_balance>=minimumBalance;
    }

    public double credit(double amount) throws InvalidCreditAmountException {
        if (canCredit(amount)) {
            balance=balance+amount;
            return balance;
        }
        throw new InvalidCreditAmountException();
    }

    private boolean canCredit(double creditAmount) {
        return creditAmount>0;
    }

}
