package com.example;

import java.util.HashMap;

public class MobilityCompany {
    private AlphaBank alphaBank;
    private HashMap<String, Double> driverPayments;
    private HashMap<String, Driver> drivers;

    public MobilityCompany(AlphaBank alphaBank) {
        this.alphaBank = alphaBank;
        this.driverPayments = new HashMap<>();
        this.drivers = new HashMap<>();
    }

    public void addDriver(Driver driver) {
        drivers.put(driver.getId(), driver);
    }

    public void startRide(String driverId, double distance) {
        Driver driver = drivers.get(driverId);

        if (driver == null) {
            System.out.println("Driver not found.");
            return;
        }

        double rideCost = distance * 0.1;
        Transaction transaction = new Transaction(driver.getId(), rideCost);
        boolean transactionSuccessful = alphaBank.processTransaction(transaction);

        if (transactionSuccessful) {
            driverPayments.put(driverId, driverPayments.getOrDefault(driverId, 0.0) + rideCost);
            System.out.println("Ride completed. Payment made to driver " + driverId);
        } else {
            System.out.println("Transaction failed. The ride cannot be completed.");
        }
    }

    public void payDrivers() {
        for (String driverId : driverPayments.keySet()) {
            double paymentAmount = driverPayments.get(driverId);
            System.out.println("Paying driver " + driverId + ": $" + paymentAmount);
            drivers.get(driverId).addToAccount(paymentAmount);
        }
    }

    public void generateReport() {

        System.out.println("Generated financial report.");
    }

}