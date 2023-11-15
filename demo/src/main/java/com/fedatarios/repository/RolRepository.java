package com.fedatarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fedatarios.model.Rol;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByDescripcion_rol(String descripcionRol);
    Optional<Rol> findByIdrol(Integer idRol);
}
