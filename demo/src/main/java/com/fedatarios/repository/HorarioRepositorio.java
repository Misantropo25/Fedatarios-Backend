package com.fedatarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fedatarios.model.Horarios;

@Repository
public interface HorarioRepositorio extends JpaRepository<Horarios, Long> {

}
