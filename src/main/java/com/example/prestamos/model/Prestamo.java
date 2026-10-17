package com.example.prestamos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "prestamos")
@Data
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String responsable;

    private LocalDate fechaPrestamo;

    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "herramienta_id", nullable = false)
    private Herramienta herramienta;
}
