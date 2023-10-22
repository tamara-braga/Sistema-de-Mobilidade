package com.example;

public class Car {
    private String id;
    private double fuelLevel;

    public Car(String id) {
        this.id = id;
        this.fuelLevel = 100.0; // Tanque cheio.
    }

    public String getId() {
        return id;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void drive(double distance) {

        double fuelConsumption = distance * 0.05;  
        fuelLevel -= fuelConsumption;
    }

    public void refuel(double fuelAmount) {

        fuelLevel += fuelAmount;
    }
}
