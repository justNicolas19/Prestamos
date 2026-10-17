package com.example.prestamos.service.ServiceImp;

import com.example.prestamos.model.Herramienta;
import com.example.prestamos.repository.HerramientaRepository;
import com.example.prestamos.service.HerramientaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class HerramientaServiceImpl implements HerramientaService {

    private final HerramientaRepository herramientaRepository;

    @Override
    public Herramienta registrar(Herramienta herramienta) {
        if (herramienta.getCantidad() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "La cantidad no puede ser negativa");
        }
        herramienta.setId(null);
        return herramientaRepository.save(herramienta);
    }

    @Override
    public List<Herramienta> listar() {
        return herramientaRepository.findAll();
    }
}
