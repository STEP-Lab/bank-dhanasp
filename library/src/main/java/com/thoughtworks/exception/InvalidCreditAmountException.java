package com.thoughtworks.exception;

public class InvalidCreditAmountException extends Throwable {
    public InvalidCreditAmountException() {
        super("Invalid Credit Amount");
    }
}
