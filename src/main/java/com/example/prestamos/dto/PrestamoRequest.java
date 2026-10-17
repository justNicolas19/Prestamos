package com.example.prestamos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record PrestamoRequest(

        @NotNull(message = "La herramienta es obligatoria")
        Long herramientaId,

        @NotBlank(message = "El responsable es obligatorio")
        String responsable,

        @NotNull(message = "La fecha es obligatoria")
        LocalDate fechaPrestamo,

        @NotNull(message = "La cantidad es obligatoria")
        Integer cantidad
) {}
