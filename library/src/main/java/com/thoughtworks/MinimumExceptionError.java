package com.thoughtworks;

public class MinimumExceptionError extends Throwable {

    public MinimumExceptionError() {
        super("insufficient minimum balance");
    }
}
