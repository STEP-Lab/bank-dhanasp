package com.thoughtworks;

public class Account {
    private final String accountNumber;
    private float balance;
    private final float minimumBalance=200;
    public Account(String accountNumber, float balance) throws MinimumExceptionError, InvalidAccountNumberException {
        validateAccountNumber(accountNumber);
        this.accountNumber = accountNumber;
        if (balance<=minimumBalance){
            throw new MinimumExceptionError();
        }
        this.balance = balance;
    }

    private static void validateAccountNumber(String accountNumber) throws InvalidAccountNumberException {
        boolean match=accountNumber.matches("\\d{4}-\\d{4}");
        if (!match){
            throw new InvalidAccountNumberException();
        }
    }

    public float getBalance() {
        return balance;
    }

    public void debit(float amount) throws MinimumExceptionError {
        balance -= amount;
        if (balance<=minimumBalance){
            throw new MinimumExceptionError();
        }
    }
}
