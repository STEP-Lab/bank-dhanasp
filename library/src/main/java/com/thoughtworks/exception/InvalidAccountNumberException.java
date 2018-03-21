package com.thoughtworks.exception;

public class InvalidAccountNumberException extends Exception {
    public InvalidAccountNumberException() {
        super("Invalid Account number");
    }
}
