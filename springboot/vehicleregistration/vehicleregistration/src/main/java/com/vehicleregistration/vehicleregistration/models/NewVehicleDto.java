package com.vehicleregistration.vehicleregistration.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NewVehicleDto(@NotNull String veiculo, @NotNull String marca,@NotNull String cor, @NotNull Integer ano, @NotNull  String descricao, Boolean vendido) {
}
