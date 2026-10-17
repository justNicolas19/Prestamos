package com.example.prestamos.service;

import com.example.prestamos.dto.PrestamoRequest;
import com.example.prestamos.model.Prestamo;
import java.util.List;

public interface PrestamoService {
    Prestamo registrar(PrestamoRequest request);
    List<Prestamo> listar();
    List<Prestamo> listarPorHerramienta(Long herramientaId);
}
