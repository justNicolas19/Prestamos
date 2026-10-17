package com.example.prestamos.controller;

import com.example.prestamos.model.Herramienta;
import com.example.prestamos.service.HerramientaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/herramientas")
@AllArgsConstructor
public class HerramientaController {

    private final HerramientaService herramientaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Herramienta registrar(@Valid @RequestBody Herramienta herramienta) {
        return herramientaService.registrar(herramienta);
    }

    @GetMapping
    public List<Herramienta> listar() {
        return herramientaService.listar();
    }
}
