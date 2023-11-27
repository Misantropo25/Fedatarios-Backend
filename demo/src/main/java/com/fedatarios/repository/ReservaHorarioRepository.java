package com.fedatarios.repository;

import com.fedatarios.model.ReservaHorario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaHorarioRepository extends JpaRepository<ReservaHorario, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
}