package com.example;
import java.util.HashMap;

public class AlphaBank {
    private HashMap<String, Double> accountBalances;

    public AlphaBank() {
        accountBalances = new HashMap<>();
    }

    public boolean processTransaction(Transaction transaction) {
        String accountHolder = transaction.getAccountHolder();
        double amount = transaction.getAmount();

        if (!accountBalances.containsKey(accountHolder)) {
            return false;
        }
        double currentBalance = accountBalances.get(accountHolder);
        if (currentBalance + amount < 0) {
            return false; // Não permitir transações com saldo negativo.
        }

        accountBalances.put(accountHolder, currentBalance + amount);
        return true;
    }

    public void createAccount(String accountHolder) {
        accountBalances.put(accountHolder, 0.0);
    }

}
