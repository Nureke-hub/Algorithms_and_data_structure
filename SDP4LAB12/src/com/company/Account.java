package com.company;

public class Account implements Comparable<Account> {
    private String name;
    private int subscribers = 0;

    public Account(String name, int subscribers) {
        this.name = name;
        this.subscribers = subscribers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(int subscribers) {
        this.subscribers = subscribers;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", subscribers=" + subscribers +
                '}';
    }

    @Override
    public int compareTo(Account o) {
        if(this.name.compareTo(o.name) > 0)
            return 1;
        else if (this.name.compareTo(o.name) < 0) return -1;
        return 0;
    }
}
