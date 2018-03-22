package com.thoughtworks;

import java.util.Date;
import java.util.Objects;

abstract class Transaction {
    private final Date date;
    private final AccountNumber to;
    private final float amount;

    public Transaction(Date date, float amount, AccountNumber to) {
        this.date = date;
        this.to = to;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Float.compare(that.amount, amount) == 0 &&
                Objects.equals(to, that.to);
    }

    @Override
    public int hashCode() {

        return Objects.hash(to, amount);
    }
}
