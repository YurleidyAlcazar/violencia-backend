package com.andrea.violencia.controller;

import com.andrea.violencia.model.CasoViolencia;
import org.springframework.web.bind.annotation.*;
import com.andrea.violencia.service.CasoViolenciaService;
import java.util.List;

@RestController
@RequestMapping("/api/casos")
@CrossOrigin(origins = "*")
public class CasoViolenciaController {

    private final CasoViolenciaService service;

    public CasoViolenciaController(CasoViolenciaService service) {
        this.service = service;
    }

    @PostMapping
    public CasoViolencia crearCaso(@RequestBody CasoViolencia caso) {
        return service.crearCaso(caso);
    }

    @GetMapping
    public List<CasoViolencia> listarCasos() {
        return service.listarCasos();
    }

    @GetMapping("/estado/{estado}")
    public List<CasoViolencia> buscarPorEstado(@PathVariable String estado) {
        return service.buscarPorEstado(estado);
    }

    @PutMapping("/{id}/estado")
    public CasoViolencia actualizarEstado(
            @PathVariable Long id,
            @RequestParam String estado) {
        return service.actualizarEstado(id, estado);
    }
}
