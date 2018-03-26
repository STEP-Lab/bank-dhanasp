package com.thoughtworks;

import com.thoughtworks.exception.InvalidAccountNumberException;

import java.util.Objects;

public class AccountNumber {

    private final String accountNumber;

    public AccountNumber(String accountNumber) throws InvalidAccountNumberException {
        this.accountNumber = accountNumber;
        validateAccountNumber(accountNumber);


    }

    private static void validateAccountNumber(String accountNumber) throws InvalidAccountNumberException {
        boolean match = accountNumber.matches("\\d{4}-\\d{4}");
        if (!match) {
            throw new InvalidAccountNumberException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountNumber that = (AccountNumber) o;
        return Objects.equals(accountNumber, that.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }
}