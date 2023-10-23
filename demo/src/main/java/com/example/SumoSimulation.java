package com.example;

import org.traccis4j.TraCIAPI;
import org.traccis4j.TraCIException;
import org.traccis4j.TraCIResult;

public class SumoSimulation {
    private TraCIAPI traCI;

    public SumoSimulation() {
        // Inicialize a conexão com o SUMO
        try {
            traCI = new TraCIAPI("localhost", 8813);
            traCI.connect();
        } catch (TraCIException e) {
            e.printStackTrace();
        }
    }

    public void startSimulation(String configFile) {
        try {
            traCI.loadScenario(configFile);

            // Inicie a simulação
            traCI.simulationStep();
        } catch (TraCIException e) {
            e.printStackTrace();
        }
    }

    public void stepSimulation() {
        try {
            // Execute um passo da simulação
            traCI.simulationStep();
        } catch (TraCIException e) {
            e.printStackTrace();
        }
    }

    public void stopSimulation() {
        try {
            // Encerre a simulação e desconecte do SUMO
            traCI.close();
        } catch (TraCIException e) {
            e.printStackTrace();
        }
    }

    public void controlVehicle(String vehicleId, double speed) {
        try {
            // Controle um veículo definindo sua velocidade
            traCI.vehicle.setSpeed(vehicleId, speed);
        } catch (TraCIException e) {
            e.printStackTrace();
        }
    }

    public double getVehiclePositionX(String vehicleId) {
        try {
            // Obtenha a posição X de um veículo
            TraCIResult result = traCI.vehicle.getPosition(vehicleId);
            return result.getPosition().getX();
        } catch (TraCIException e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    public void close() {
        // Certifique-se de fechar a conexão com o SUMO ao final do uso
        traCI.close();
    }
}


