package com.fedatarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fedatarios.model.UsuarioDeclaracionesJuradas;

@Repository
public interface UsuarioDecalracionesJuradasRepositorio extends JpaRepository<UsuarioDeclaracionesJuradas, Long> {

}
