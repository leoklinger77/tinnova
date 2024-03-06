package com.vehicleregistration.vehicleregistration.controllers;

import com.vehicleregistration.vehicleregistration.entities.Vehicle;
import com.vehicleregistration.vehicleregistration.models.EditVehicleDto;
import com.vehicleregistration.vehicleregistration.models.NewVehicleDto;
import com.vehicleregistration.vehicleregistration.models.SimpleEditVehicleDto;
import com.vehicleregistration.vehicleregistration.models.SuccessResponse;
import com.vehicleregistration.vehicleregistration.services.NotificationServices;
import com.vehicleregistration.vehicleregistration.services.VehicleServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class VehicleController {

    @Autowired
    VehicleServices vehicleServices;
    @Autowired
    NotificationServices notificationServices;


    public ResponseEntity<Object> customResponse(@Nullable List<Vehicle> obj) {
        if (!notificationServices.hasNotification()) {
            return new ResponseEntity<Object>(new SuccessResponse<Object>(true, obj), HttpStatus.OK);
        } else{
            return new ResponseEntity<Object>(new SuccessResponse<Object>(false, notificationServices.getAllNotification()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/veiculos")
    public ResponseEntity<Object> getVeiculos() {
        List<Vehicle> result = vehicleServices.getAllVehicles();
        return customResponse(result);
    }

    @GetMapping("/veiculos?")
    public ResponseEntity<Object> getSearch(
            @RequestParam(value = "marca", required = true) String marca,
            @RequestParam(value = "ano", required = false) Integer ano,
            @RequestParam(value = "cor", required = false) String cor){
        var result = this.vehicleServices.getAllVehicles(marca, ano, cor);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/veiculos/{id}")
    public ResponseEntity<Object> getById(@PathVariable UUID id){
        var result = this.vehicleServices.getById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PostMapping("/veiculos")
    public ResponseEntity<Object> post(@RequestBody @Valid NewVehicleDto dto){
        var result = this.vehicleServices.create(dto.veiculo(), dto.marca(),  dto.cor(), dto.ano());
        if(result){
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Object());
    }

    @PutMapping("/veiculos/{id}")
    public ResponseEntity<Object> put(@PathVariable UUID id, @RequestBody EditVehicleDto dto){
        var result = this.vehicleServices.update(id, dto.veiculo(), dto.marca(), dto.cor(), dto.ano());
        if(result){
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Object());
    }

    @PatchMapping("/veiculos/{id}")
    public ResponseEntity<Object> patch(@PathVariable UUID id, @RequestBody SimpleEditVehicleDto dto ){
        var result = this.vehicleServices.updateName(id, dto.veiculo());
        if(result){
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Object());
    }

    @DeleteMapping("/veiculos/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id){
        var result = this.vehicleServices.delete(id);
        if(result){
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Object());
    }

}