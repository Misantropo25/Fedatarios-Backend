package com.fedatarios.controller;

import com.fedatarios.model.DocumentoObservacion;
import com.fedatarios.service.DocumentoObservacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/documento-observacion")
public class DocumentoObservacionController {

    private final DocumentoObservacionService documentoObservacionService;

    @Autowired
    public DocumentoObservacionController(DocumentoObservacionService documentoObservacionService) {
        this.documentoObservacionService = documentoObservacionService;
    }

    @GetMapping
    public List<DocumentoObservacion> getAllDocumentoObservacion() {
        return documentoObservacionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentoObservacion> getDocumentoObservacionById(@PathVariable Long id) {
        return documentoObservacionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DocumentoObservacion createDocumentoObservacion(@RequestBody DocumentoObservacion documentoObservacion) {
        return documentoObservacionService.save(documentoObservacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentoObservacion> updateDocumentoObservacion(@PathVariable Long id, @RequestBody DocumentoObservacion documentoObservacionDetails) {
        return documentoObservacionService.findById(id)
                .map(documentoObservacion -> {
                    documentoObservacion.setDocumentoEscaneado(documentoObservacionDetails.getDocumentoEscaneado());
                    documentoObservacion.setObservacion(documentoObservacionDetails.getObservacion());
                    DocumentoObservacion updatedDocumentoObservacion = documentoObservacionService.save(documentoObservacion);
                    return ResponseEntity.ok(updatedDocumentoObservacion);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDocumentoObservacion(@PathVariable Long id) {
        if (documentoObservacionService.findById(id).isPresent()) {
            documentoObservacionService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}