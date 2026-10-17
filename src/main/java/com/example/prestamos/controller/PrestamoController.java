package com.example.prestamos.controller;

import com.example.prestamos.dto.PrestamoRequest;
import com.example.prestamos.model.Prestamo;
import com.example.prestamos.service.PrestamoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
@AllArgsConstructor
public class PrestamoController {

    private final PrestamoService prestamoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Prestamo registrar(@Valid @RequestBody PrestamoRequest request) {
        return prestamoService.registrar(request);
    }

    @GetMapping
    public List<Prestamo> listar() {
        return prestamoService.listar();
    }

    @GetMapping("/herramienta/{id}")
    public List<Prestamo> listarPorHerramienta(@PathVariable Long id) {
        return prestamoService.listarPorHerramienta(id);
    }
}
