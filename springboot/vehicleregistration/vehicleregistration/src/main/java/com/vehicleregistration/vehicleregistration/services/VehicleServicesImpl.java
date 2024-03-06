package com.vehicleregistration.vehicleregistration.services;

import com.vehicleregistration.vehicleregistration.entities.Vehicle;
import com.vehicleregistration.vehicleregistration.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VehicleServicesImpl implements VehicleServices {
    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    NotificationServices notificationServices;

    @Override
    public List<Vehicle> getAllVehicles() {
        return this.vehicleRepository.findAll();
    }

    @Override
    public List<Vehicle> getAllVehicles(String marca, Integer ano, String cor) {
        if (marca == null && ano == null && cor == null) {
            return this.vehicleRepository.findAll();
        }

        return this.vehicleRepository.findAll().stream()
                .filter(vehicle -> (marca == null || vehicle.getMarca().equals(marca)))
                .filter(vehicle -> (ano == null || vehicle.getAno() == ano))
                .filter(vehicle -> (cor == null || vehicle.getCor().equals(cor)))
                .collect(Collectors.toList());
    }

    @Override
    public Vehicle getById(UUID id) {
        return this.vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean create(String veiculo, String marca, String cor, Integer ano) {
        var model = new Vehicle(veiculo,marca,  cor, ano);
        return false;
    }

    @Override
    public boolean update(UUID id, String veiculo, String marca, String cor, Integer ano) {
        return false;
    }

    @Override
    public boolean updateName(UUID id,String veiculo) {
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }
}
