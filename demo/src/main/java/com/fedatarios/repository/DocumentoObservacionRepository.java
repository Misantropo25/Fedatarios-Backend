package com.fedatarios.repository;

import com.fedatarios.model.DocumentoObservacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoObservacionRepository extends JpaRepository<DocumentoObservacion, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
