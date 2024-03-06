package com.vehicleregistration.vehicleregistration.models;

import jakarta.validation.constraints.NotBlank;

public record SimpleEditVehicleDto(@NotBlank String veiculo) {
}
