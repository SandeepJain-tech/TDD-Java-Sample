package com.jd;

import java.util.Objects;

public abstract class Money {
    protected int amount;
    protected String currency;
    abstract Money times(int multiplier);

    Money(int amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }

    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;

        Money money = (Money) obj;
        return amount == money.amount
                && currency.equals(money.currency);

    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    public static Money dollar(int amount){
        return new Dollar(amount, "USD");

    }

    public static Money franc(int amount){
        return new Franc(amount, "CHF");
    }

    String currency(){
        return currency;
    }
}
