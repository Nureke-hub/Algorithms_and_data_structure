package com.company.Task2;

enum Currency{
    TNG,
    USD,
    EUR,
    RUB
}

public class Money implements Comparable<Money>{
    private int number;
    private Currency currency;
    private int amount;

    public Money() {}

    public Money(int number, Currency currency, int amount) {
        this.number = number;
        this.currency = currency;
        this.amount = amount;
    }

    @Override
    public int compareTo(Money money) {
        if (this.toTenge() > money.toTenge()){
            return 1;
        } else if(this.toTenge() < money.toTenge()){
            return -1;
        }else {
            return 0;
        }
    }

    public double toTenge(){
        if(this.currency == Currency.TNG){
            return this.amount * this.number;
        }else if(this.currency == Currency.USD){
            return (this.amount * 384.2) * this.number;
        }else if(this.currency == Currency.EUR){
            return (this.amount * 415.4) * this.number;
        }else if(this.currency == Currency.RUB){
            return (this.amount * 6.1) * this.number;
        }
        return 0;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Money{" +
                "number=" + number +
                ", currency=" + currency.toString() +
                ", amount=" + amount +
                '}';
    }
}
