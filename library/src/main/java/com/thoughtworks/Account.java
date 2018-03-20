package com.thoughtworks;

public class Account {
    private float balance;
    private final String accountNumber;
    private static final float minimumBalance=200;
    public Account(String accountNumber, float balance) throws MinimumBalanceException, InvalidAccountNumberException {
        validateAccountNumber(accountNumber);
        this.accountNumber = accountNumber;
        validateBalance("Insufficient balance to create Account",balance);
        this.balance = balance;
    }

    private void validateBalance(String msg,float balance) throws MinimumBalanceException {
        if (balance<=minimumBalance){
            throw new MinimumBalanceException(msg);
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

    public void debit(float amount) throws MinimumBalanceException {
        balance -= amount;
        validateBalance("debit declined due to low balance",balance);
    }

    public void credit(float amount) {
        balance+=amount;
    }
}
