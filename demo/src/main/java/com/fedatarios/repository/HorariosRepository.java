package com.fedatarios.repository;

import com.fedatarios.model.Horarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorariosRepository extends JpaRepository<Horarios, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
}