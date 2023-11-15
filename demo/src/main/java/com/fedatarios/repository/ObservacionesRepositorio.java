package com.fedatarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fedatarios.model.Observaciones;

@Repository
public interface ObservacionesRepositorio extends JpaRepository<Observaciones, Long> {

}
