package com.example;

public class FuelStation {
    private AlphaBank alphaBank;

    public FuelStation(AlphaBank alphaBank) {
        this.alphaBank = alphaBank;
    }

    public void refuelCar(Car car, double fuelAmount) {
        
        double fuelCost = fuelAmount * 2.5; 
        boolean transactionSuccessful = alphaBank.processTransaction(new Transaction(car.getId(), -fuelCost));

        if (transactionSuccessful) {
            car.refuel(fuelAmount);
            System.out.println("Car refueled successfully.");
        } else {
            System.out.println("Transaction failed. Car cannot be refueled.");
        }
    }
}
