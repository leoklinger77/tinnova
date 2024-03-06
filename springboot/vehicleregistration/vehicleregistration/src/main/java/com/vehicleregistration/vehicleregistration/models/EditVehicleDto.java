package com.vehicleregistration.vehicleregistration.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
public record  EditVehicleDto(@NotBlank String veiculo, @NotBlank String marca, @NotBlank String cor, @NotNull Integer ano, @NotBlank  String descricao, Boolean vendido)  {
}
