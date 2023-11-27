package com.fedatarios.service;

import com.fedatarios.model.TipoDocumento;
import com.fedatarios.repository.TipoDocumentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TipoDocumentoService {

    private final TipoDocumentoRepositorio tipoDocumentoRepository;

    @Autowired
    public TipoDocumentoService(TipoDocumentoRepositorio tipoDocumentoRepository) {
        this.tipoDocumentoRepository = tipoDocumentoRepository;
    }

    public List<TipoDocumento> findAll() {
        return tipoDocumentoRepository.findAll();
    }

    public Optional<TipoDocumento> findById(Long id) {
        return tipoDocumentoRepository.findById(id);
    }

    public TipoDocumento save(TipoDocumento tipoDocumento) {
        return tipoDocumentoRepository.save(tipoDocumento);
    }

    public void deleteById(Long id) {
        tipoDocumentoRepository.deleteById(id);
    }
}