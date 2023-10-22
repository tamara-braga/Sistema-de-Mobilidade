package com.example;

public class Driver {
    private String id;
    private double accountBalance;

    public Driver(String id) {
        this.id = id;
        this.accountBalance = 0.0;
    }

    public String getId() {
        return id;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void addToAccount(double amount) {
        accountBalance += amount;
    }
}
