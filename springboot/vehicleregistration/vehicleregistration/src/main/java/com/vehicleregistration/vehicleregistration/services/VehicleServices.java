package com.vehicleregistration.vehicleregistration.services;

import com.vehicleregistration.vehicleregistration.entities.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface VehicleServices {
    List<Vehicle> getAllVehicles();
    List<Vehicle> getAllVehicles(String marca, Integer ano, String cor);
    Vehicle getById(UUID id);
    boolean create(String veiculo, String marca, String cor, Integer ano);
    boolean update(UUID id,String veiculo, String marca, String cor, Integer ano);
    boolean updateName(UUID id,String veiculo);
    boolean delete(UUID id);

}
