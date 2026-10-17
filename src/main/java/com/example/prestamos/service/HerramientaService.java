package com.example.prestamos.service;

import com.example.prestamos.model.Herramienta;
import java.util.List;

public interface HerramientaService {
    Herramienta registrar(Herramienta herramienta);
    List<Herramienta> listar();
}
