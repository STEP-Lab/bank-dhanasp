package com.thoughtworks;

public class Account {
    private float balance;
    private final String accountNumber;
    private static final float minimumBalance=200;
    public Account(String accountNumber, float balance) throws MinimumExceptionError, InvalidAccountNumberException {
        validateAccountNumber(accountNumber);
        this.accountNumber = accountNumber;
        this.balance = balance;
        validateBalance("Insufficient balance to create Account");
    }

    private void validateBalance(String msg) throws MinimumExceptionError {
        if (balance<=minimumBalance){
            throw new MinimumExceptionError(msg);
        }
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
        validateBalance("debit declined due to low balance");
    }
}
