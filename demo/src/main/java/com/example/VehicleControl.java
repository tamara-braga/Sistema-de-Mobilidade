package com.example;
import java.util.concurrent.TimeUnit;

public class VehicleControl {

    public void moveVehicle(String vehicleId, double distance) {
        // Simule o movimento do veículo
        System.out.println("Movendo veículo " + vehicleId + " por " + distance + " km.");
    }

    public void waitFor(double seconds) {
        // Simule a espera
        try {
            TimeUnit.SECONDS.sleep((long) (seconds * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void refuelVehicle(String vehicleId, double liters) {
        // Simule o abastecimento do veículo
        System.out.println("Abastecendo veículo " + vehicleId + " com " + liters + " litros de combustível.");
    }

    public void collectData(String vehicleId) {
        // Simule a coleta de dados
        System.out.println("Coletando dados do veículo " + vehicleId);
    }
}
