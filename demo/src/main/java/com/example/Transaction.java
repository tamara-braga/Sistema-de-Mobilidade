package com.example;

public class Transaction {
    private String accountHolder;
    private double amount;

    public Transaction(String accountHolder, double amount) {
        this.accountHolder = accountHolder;
        this.amount = amount;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getAmount() {
        return amount;
    }
}
