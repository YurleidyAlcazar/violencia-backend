package com.andrea.violencia.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.andrea.violencia.model.CasoViolencia;
import com.andrea.violencia.repository.CasoViolenciaRepository;

@Service
public class CasoViolenciaService {

    private final CasoViolenciaRepository repository;

    public CasoViolenciaService(CasoViolenciaRepository repository) {
        this.repository = repository;
    }

    public CasoViolencia crearCaso(CasoViolencia caso) {
        caso.setFechaReporte(LocalDate.now());
        caso.setEstado("ABIERTO");
        return repository.save(caso);
    }

    public List<CasoViolencia> listarCasos() {
        return repository.findAll();
    }

    public List<CasoViolencia> buscarPorEstado(String estado) {
        return repository.findByEstado(estado);
    }

    public CasoViolencia actualizarEstado(Long id, String estado) {
        CasoViolencia caso = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Caso no encontrado"));
        caso.setEstado(estado);
        return repository.save(caso);
    }
}
