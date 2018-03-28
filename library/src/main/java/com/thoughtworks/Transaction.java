package com.thoughtworks;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

abstract class Transaction {
    private final Date date;
    private final AccountNumber to;
    private final double amount;

    public Transaction(Date date, double amount, AccountNumber to) {
        this.date = date;
        this.to = to;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }


    public Date getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.amount, amount) == 0 &&
                Objects.equals(to, that.to);
    }

    @Override
    public int hashCode() {

        return Objects.hash(to, amount);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date +
                ", to=" + to +
                ", amount=" + amount +
                '}';
    }

    public String toCSV(){
       ArrayList<String> transactionInCSV=new ArrayList<>();
       transactionInCSV.add(date.toString());
       transactionInCSV.add(to.getAccountNumber());
       transactionInCSV.add(String.valueOf(amount));
       return String.join(",",transactionInCSV);
    }
}
