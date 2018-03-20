package com.thoughtworks;

public class Account {
    private final String accountNumber;
    private final float balance;

    public Account(String accountNumber, float balance) throws MinimumExceptionError, InvalidAccountNumberException {
        validateAccountNumber(accountNumber);
        this.accountNumber = accountNumber;
        if (balance<=200){
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

    public float debit(float amount) {
        return balance-amount;
    }
}
