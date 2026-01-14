package com.andrea.violencia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrea.violencia.model.CasoViolencia;

public interface CasoViolenciaRepository extends JpaRepository<CasoViolencia, Long> {

    List<CasoViolencia> findByEstado(String estado);

    List<CasoViolencia> findByTipoViolencia(String tipoViolencia);
}
