package com.example.prestamos.service.ServiceImp;

import com.example.prestamos.dto.PrestamoRequest;
import com.example.prestamos.model.Herramienta;
import com.example.prestamos.model.Prestamo;
import com.example.prestamos.repository.HerramientaRepository;
import com.example.prestamos.repository.PrestamoRepository;
import com.example.prestamos.service.PrestamoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class PrestamoServiceImpl implements PrestamoService {

    private final PrestamoRepository prestamoRepository;
    private final HerramientaRepository herramientaRepository;

    @Override
    @Transactional
    public Prestamo registrar(PrestamoRequest request) {

        Herramienta herramienta = herramientaRepository.findById(request.herramientaId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No existe la herramienta con id " + request.herramientaId()));

        if (request.cantidad() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "La cantidad a prestar debe ser mayor que cero");
        }

        if (request.cantidad() > herramienta.getCantidad()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Unidades insuficientes. Disponibles: " + herramienta.getCantidad());
        }

        herramienta.setCantidad(herramienta.getCantidad() - request.cantidad());
        herramientaRepository.save(herramienta);

        Prestamo prestamo = new Prestamo();
        prestamo.setResponsable(request.responsable());
        prestamo.setFechaPrestamo(request.fechaPrestamo());
        prestamo.setCantidad(request.cantidad());
        prestamo.setHerramienta(herramienta);

        return prestamoRepository.save(prestamo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Prestamo> listar() {
        return prestamoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Prestamo> listarPorHerramienta(Long herramientaId) {
        if (!herramientaRepository.existsById(herramientaId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "No existe la herramienta con id " + herramientaId);
        }
        return prestamoRepository.findByHerramientaId(herramientaId);
    }
}
