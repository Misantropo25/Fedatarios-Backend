package com.fedatarios.repository;

import com.fedatarios.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fedatarios.model.Legajo;

import java.util.Optional;

public interface LegajoRepository extends JpaRepository<Legajo, Long> {
    Optional<Legajo> findByIdlegajo(Integer idLegajo);

}
