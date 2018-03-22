package com.thoughtworks;


import com.thoughtworks.exception.InvalidCreditAmountException;
import com.thoughtworks.exception.InvalidDebitAmountException;
import com.thoughtworks.exception.MinimumBalanceException;

public class Account {
    private static final float minimumBalance=200;
    private float balance;

    public Account(AccountNumber accountNumber, float balance) throws MinimumBalanceException {
        validateBalance(balance);
        this.balance=balance;
    }

    public float getBalance() {
        return balance;
    }

    private static void validateBalance(float balance) throws MinimumBalanceException {
        if (balance<=minimumBalance){
            throw new MinimumBalanceException();
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
