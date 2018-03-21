package com.thoughtworks.exception;

public class MinimumBalanceException extends Exception {
    public MinimumBalanceException() {
        super("Insufficient Balance for creating account");
    }
}
