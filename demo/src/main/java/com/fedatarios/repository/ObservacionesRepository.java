package com.fedatarios.repository;

import com.fedatarios.model.Observaciones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObservacionesRepository extends JpaRepository<Observaciones, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
