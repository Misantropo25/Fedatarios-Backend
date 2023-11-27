package com.fedatarios.service;

import com.fedatarios.model.Documentos_Escaneados;
import com.fedatarios.repository.DocumentosEscaneadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentosEscaneadosService {

    private final DocumentosEscaneadosRepository documentosEscaneadosRepository;

    @Autowired
    public DocumentosEscaneadosService(DocumentosEscaneadosRepository documentosEscaneadosRepository) {
        this.documentosEscaneadosRepository = documentosEscaneadosRepository;
    }

    public List<Documentos_Escaneados> findAll() {
        return documentosEscaneadosRepository.findAll();
    }

    public Optional<Documentos_Escaneados> findById(Long id) {
        return documentosEscaneadosRepository.findById(id);
    }

    public Documentos_Escaneados save(Documentos_Escaneados documento) {
        return documentosEscaneadosRepository.save(documento);
    }

    public void deleteById(Long id) {
        documentosEscaneadosRepository.deleteById(id);
    }
}
