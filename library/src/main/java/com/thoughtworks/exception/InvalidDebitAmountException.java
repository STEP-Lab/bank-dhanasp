package com.thoughtworks.exception;

public class InvalidDebitAmountException extends Throwable {
    public InvalidDebitAmountException() {
        super("Invalid debit amount");
    }
}
