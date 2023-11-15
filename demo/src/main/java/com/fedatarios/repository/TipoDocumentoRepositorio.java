package com.fedatarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fedatarios.model.TipoDocumento;

@Repository
public interface TipoDocumentoRepositorio extends JpaRepository<TipoDocumento, Long> {

}
