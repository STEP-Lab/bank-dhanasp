package com.thoughtworks;

import com.thoughtworks.exception.InvalidAccountNumberException;
import org.junit.Test;

public class AccountNumberTest {
    @Test
    public void checkAccountNumber() throws InvalidAccountNumberException {
        new AccountNumber("1234-2345");
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void shouldValidateAccountNumber() throws InvalidAccountNumberException {
        new AccountNumber("1234");
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void checkAccountNumberValidationForAlphabets() throws InvalidAccountNumberException {
        new AccountNumber("1234-absd");
    }
}
