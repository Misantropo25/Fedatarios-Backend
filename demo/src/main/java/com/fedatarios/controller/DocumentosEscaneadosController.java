package com.fedatarios.controller;

import com.fedatarios.dto.DocumentosEscaneadosDTO;
import com.fedatarios.model.Documentos_Escaneados;
import com.fedatarios.model.Legajo;
import com.fedatarios.model.TipoDocumento;
import com.fedatarios.repository.DocumentosEscaneadosRepository;
import com.fedatarios.repository.TipoDocumentoRepositorio;
import com.fedatarios.service.DocumentosEscaneadosService;
import com.fedatarios.service.LegajoService;
import com.fedatarios.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/documentos-escaneados")
public class DocumentosEscaneadosController {

    private final DocumentosEscaneadosService documentosEscaneadosService;

    @Autowired
    private LegajoService legajoService;

    @Autowired
    private DocumentosEscaneadosRepository documentosEscaneadosRepository;

    @Autowired
    private TipoDocumentoRepositorio tipoDocumentoRepository;

    @Autowired
    private StorageService storageService;

    @Autowired
    public DocumentosEscaneadosController(DocumentosEscaneadosService documentosEscaneadosService) {
        this.documentosEscaneadosService = documentosEscaneadosService;
    }

    @GetMapping("/listar_documentos")
    public ResponseEntity<List<DocumentosEscaneadosDTO>> getAllDocumentosEscaneados() {
        List<Documentos_Escaneados> documentos = documentosEscaneadosService.findAll();
        List<DocumentosEscaneadosDTO> dtos = documentos.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    private DocumentosEscaneadosDTO convertToDTO(Documentos_Escaneados documento) {
        DocumentosEscaneadosDTO dto = new DocumentosEscaneadosDTO();
        dto.setId(documento.getIddoc_escaneado());
        dto.setRutaArchivo(documento.getRutaArchivo());
        dto.setRutaArchivoFirmado(documento.getRutaArchivoFirmado());
        dto.setFirmado(documento.getFirmado());
        if (documento.getTipo_documento() != null) {
            dto.setTipoDocumentoId(documento.getTipo_documento().getIdtipo_documento());
        }
        if (documento.getLegajo() != null) {
            dto.setLegajoId(documento.getLegajo().getIdlegajo());
        }
        // Completa otros campos necesarios
        return dto;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Documentos_Escaneados> getDocumentoEscaneadoById(@PathVariable Long id) {
        return documentosEscaneadosService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Documentos_Escaneados createDocumentoEscaneado(@RequestBody Documentos_Escaneados documento) {
        return documentosEscaneadosService.save(documento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Documentos_Escaneados> updateDocumentoEscaneado(@PathVariable Long id, @RequestBody Documentos_Escaneados documentoDetails) {
        return documentosEscaneadosService.findById(id)
                .map(documento -> {
                    documento.setTipo_documento(documentoDetails.getTipo_documento());
                    documento.setRutaArchivo(documentoDetails.getRutaArchivo());
                    documento.setRutaArchivoFirmado(documentoDetails.getRutaArchivoFirmado());
                    documento.setFirmado(documentoDetails.getFirmado());
                    documento.setLegajo(documentoDetails.getLegajo());
                    // Agrega cualquier otro campo que necesites actualizar
                    Documentos_Escaneados updatedDocumento = documentosEscaneadosService.save(documento);
                    return ResponseEntity.ok(updatedDocumento);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDocumentoEscaneado(@PathVariable Long id) {
        if (documentosEscaneadosService.findById(id).isPresent()) {
            documentosEscaneadosService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

//    End Points para la subida de documentos

    @PostMapping("/upload")
    public ResponseEntity<?> uploadDocumentos(@RequestParam("files") MultipartFile[] files,
                                              @RequestParam("tipoDocumentoIds") Long[] tipoDocumentoIds) {
        try {
            if (files.length != tipoDocumentoIds.length) {
                throw new RuntimeException("El número de archivos no coincide con el número de tipos de documento.");
            }

            List<String> filenames = new ArrayList<>();
            Legajo legajo = new Legajo();
            legajo.setFecha(new Date());
            legajo = legajoService.save(legajo); // Guardar el legajo y obtener el legajo con ID

            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                Long tipoDocumentoId = tipoDocumentoIds[i];

                TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(tipoDocumentoId)
                        .orElseThrow(() -> new RuntimeException("Tipo de documento no encontrado con ID: " + tipoDocumentoId));

                String filename = storageService.store(file);
                Documentos_Escaneados documentosEscaneados = new Documentos_Escaneados();
                documentosEscaneados.setTipo_documento(tipoDocumento);
                documentosEscaneados.setLegajo(legajo);
                documentosEscaneados.setRutaArchivo(filename);
                documentosEscaneados.setFirmado(false);
                documentosEscaneadosRepository.save(documentosEscaneados);
                filenames.add(filename);
            }

            return ResponseEntity.ok("Documentos subidos exitosamente: " + String.join(", ", filenames));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al subir archivos: " + e.getMessage());
        }
    }

}
