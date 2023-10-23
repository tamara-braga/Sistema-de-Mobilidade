package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        // Crie uma instância do AlphaBank e da MobilityCompany
        AlphaBank alphaBank = new AlphaBank();
        MobilityCompany mobilityCompany = new MobilityCompany(alphaBank);

        // Adicione drivers à MobilityCompany
        Driver driver1 = new Driver("Driver1");
        Driver driver2 = new Driver("Driver2");
        mobilityCompany.addDriver(driver1);
        mobilityCompany.addDriver(driver2);

        // Inicie uma viagem para os motoristas
        mobilityCompany.startRide(driver1.getId(), 10.0);
        mobilityCompany.startRide(driver2.getId(), 5.0);
        mobilityCompany.payDrivers();

        // Crie uma instância da FuelStation e Car
        FuelStation fuelStation = new FuelStation(alphaBank);
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");

        // Abasteça os carros
        fuelStation.refuelCar(car1, 20.0);
        fuelStation.refuelCar(car2, 15.0);

        // Simule a condução dos carros
        car1.drive(12.0);
        car2.drive(8.0);

        // Gere um relatório
        mobilityCompany.generateReport();

        // Imprima o saldo de motoristas e carros para verificar as transações.
        System.out.println("Saldo do Driver1: $" + driver1.getAccountBalance());
        System.out.println("Saldo do Driver2: $" + driver2.getAccountBalance());
        System.out.println("Nível de combustível do Car1: " + car1.getFuelLevel() + " litros");
        System.out.println("Nível de combustível do Car2: " + car2.getFuelLevel() + " litros");

        // Agora, você pode integrar a classe SumoSimulation para lidar com a simulação SUMO.
        // Certifique-se de que a classe SumoSimulation seja acessível a partir deste ponto.
        SumoSimulation sumoSim = new SumoSimulation();
        
        // Realize as operações de integração com o SUMO conforme necessário.
        sumoSim.startSimulation("caminho/para/seu/arquivo_de_configuracao.sumocfg");
        
        // Execute os passos da simulação e outras operações no SUMO.
        sumoSim.stepSimulation();
        
        // Encerre a simulação quando necessário.
        sumoSim.stopSimulation();
    }
}
