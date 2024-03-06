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
        return this.vehicleRepository.findAll().stream()
                .filter(vehicle -> (marca == null || vehicle.getMarca().equals(marca)))
                .filter(vehicle -> (ano == null || vehicle.getAno().equals(ano)))
                .filter(vehicle -> (cor == null || vehicle.getCor().equalsIgnoreCase(cor)))
                .collect(Collectors.toList());
    }

    @Override
    public Vehicle getById(UUID id) {
        var result = this.vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getId().equals(id))
                .findFirst()
                .orElse(null);

        if(result == null){
            notificationServices.addNotification("Id nao encontrado");
        }
        return  result;
    }

    @Override
    public boolean create(String veiculo, String marca, String cor, Integer ano) {
        var exit = this.vehicleRepository.findAll().stream()
                .filter(vehicle -> (vehicle.getVeiculo().equals(veiculo)))
                .findFirst();

        if(exit.isPresent()){
            notificationServices.addNotification("Veiculo ja cadastrado");
            return  false;
        }

        var model = new Vehicle(veiculo,marca,  cor, ano);
        vehicleRepository.save(model);
        return true;
    }

    @Override
    public boolean update(UUID id, String veiculo, String marca, String cor, Integer ano) {
        Vehicle exit = getById(id);

        if(exit == null){
            notificationServices.addNotification("Id nao localizado");
            return  false;
        }

        exit.setVeiculo(veiculo);
        exit.setMarca(marca);
        exit.setCor(cor);
        exit.setAno(ano);

        vehicleRepository.save(exit);
        return true;
    }

    @Override
    public boolean updateName(UUID id,String veiculo) {
        Vehicle exit = getById(id);

        if(exit == null){
            notificationServices.addNotification("Id nao localizado");
            return  false;
        }

        exit.setVeiculo(veiculo);

        vehicleRepository.save(exit);
        return true;
    }

    @Override
    public boolean delete(UUID id) {
        Vehicle exit = getById(id);

        if(exit == null){
            notificationServices.addNotification("Id nao localizado");
            return  false;
        }
        vehicleRepository.delete(exit);
        return true;
    }
}
