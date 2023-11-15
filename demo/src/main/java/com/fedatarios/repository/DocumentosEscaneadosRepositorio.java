package com.fedatarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fedatarios.model.Documentos_Escaneados;

@Repository
public interface DocumentosEscaneadosRepositorio extends JpaRepository<Documentos_Escaneados, Long>{

}
