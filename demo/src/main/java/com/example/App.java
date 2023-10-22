package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AlphaBank alphaBank = new AlphaBank();
        MobilityCompany mobilityCompany = new MobilityCompany(alphaBank);

        Driver driver1 = new Driver("Driver1");
        Driver driver2 = new Driver("Driver2");
        mobilityCompany.addDriver(driver1);
        mobilityCompany.addDriver(driver2);

        mobilityCompany.startRide(driver1.getId(), 10.0);
        mobilityCompany.startRide(driver2.getId(), 5.0);
        mobilityCompany.payDrivers();

        FuelStation fuelStation = new FuelStation(alphaBank);
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");

        fuelStation.refuelCar(car1, 20.0);
        fuelStation.refuelCar(car2, 15.0);

        car1.drive(12.0);
        car2.drive(8.0);

        mobilityCompany.generateReport();

        // Imprima o saldo de motoristas e carros para verificar as transações.
        System.out.println("Saldo do Driver1: $" + driver1.getAccountBalance());
        System.out.println("Saldo do Driver2: $" + driver2.getAccountBalance());
        System.out.println("Nível de combustível do Car1: " + car1.getFuelLevel() + " litros");
        System.out.println("Nível de combustível do Car2: " + car2.getFuelLevel() + " litros");
    }
}
