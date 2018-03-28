package com.thoughtworks;

import java.io.IOException;
import java.util.ArrayList;

public interface Printer {
    void print(Transaction transaction) throws IOException;

    void print(ArrayList<Transaction> allTransactions) throws IOException;
}

