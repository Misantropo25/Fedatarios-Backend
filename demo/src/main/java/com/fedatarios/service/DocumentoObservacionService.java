package com.fedatarios.service;

import com.fedatarios.model.DocumentoObservacion;
import com.fedatarios.repository.DocumentoObservacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentoObservacionService {

    private final DocumentoObservacionRepository documentoObservacionRepository;

    @Autowired
    public DocumentoObservacionService(DocumentoObservacionRepository documentoObservacionRepository) {
        this.documentoObservacionRepository = documentoObservacionRepository;
    }

    public List<DocumentoObservacion> findAll() {
        return documentoObservacionRepository.findAll();
    }

    public Optional<DocumentoObservacion> findById(Long id) {
        return documentoObservacionRepository.findById(id);
    }

    public DocumentoObservacion save(DocumentoObservacion documentoObservacion) {
        return documentoObservacionRepository.save(documentoObservacion);
    }

    public void deleteById(Long id) {
        documentoObservacionRepository.deleteById(id);
    }
}