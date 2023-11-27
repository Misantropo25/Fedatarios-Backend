package com.fedatarios.controller;

import com.fedatarios.dto.TipoDocumentoDTO;
import com.fedatarios.model.TipoDocumento;
import com.fedatarios.repository.TipoDocumentoRepositorio;
import com.fedatarios.service.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tipo-documentos")
public class TipoDocumentoController {

    private final TipoDocumentoService tipoDocumentoService;

    @Autowired
    private TipoDocumentoRepositorio tipoDocumentoRepository;

    @Autowired
    public TipoDocumentoController(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TipoDocumentoDTO>> getAllTipoDocumentos() {
        List<TipoDocumento> tipos = tipoDocumentoRepository.findAll();
        List<TipoDocumentoDTO> dtos = tipos.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        if (dtos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(dtos);
    }

    private TipoDocumentoDTO convertToDTO(TipoDocumento tipoDocumento) {
        return new TipoDocumentoDTO(tipoDocumento.getIdtipo_documento(), tipoDocumento.getDescripcion());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDocumento> getTipoDocumentoById(@PathVariable Long id) {
        return tipoDocumentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TipoDocumento> createTipoDocumento(@RequestBody TipoDocumento tipoDocumento) {
        TipoDocumento savedTipoDocumento = tipoDocumentoService.save(tipoDocumento);
        return ResponseEntity.ok(savedTipoDocumento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoDocumento> updateTipoDocumento(@PathVariable Long id, @RequestBody TipoDocumento tipoDocumentoDetails) {
        return tipoDocumentoService.findById(id)
                .map(tipoDocumento -> {
                    tipoDocumento.setDescripcion(tipoDocumentoDetails.getDescripcion());
                    // Agrega cualquier otro campo que necesites actualizar
                    TipoDocumento updatedTipoDocumento = tipoDocumentoService.save(tipoDocumento);
                    return ResponseEntity.ok(updatedTipoDocumento);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTipoDocumento(@PathVariable Long id) {
        if (tipoDocumentoService.findById(id).isPresent()) {
            tipoDocumentoService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}