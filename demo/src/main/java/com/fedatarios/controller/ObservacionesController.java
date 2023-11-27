package com.fedatarios.controller;

import com.fedatarios.model.Observaciones;
import com.fedatarios.service.ObservacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/observaciones")
public class ObservacionesController {

    private final ObservacionesService observacionesService;

    @Autowired
    public ObservacionesController(ObservacionesService observacionesService) {
        this.observacionesService = observacionesService;
    }

    @GetMapping
    public List<Observaciones> getAllObservaciones() {
        return observacionesService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Observaciones> getObservacionById(@PathVariable Long id) {
        return observacionesService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Observaciones addObservacion(@RequestBody Observaciones observacion) {
        return observacionesService.save(observacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Observaciones> updateObservacion(@PathVariable Long id, @RequestBody Observaciones observacionDetails) {
        return observacionesService.findById(id)
                .map(observacion -> {
                    observacion.setDescripcion(observacionDetails.getDescripcion());
                    // otros campos a actualizar
                    Observaciones updatedObservacion = observacionesService.save(observacion);
                    return ResponseEntity.ok(updatedObservacion);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteObservacion(@PathVariable Long id) {
        if (observacionesService.findById(id).isPresent()) {
            observacionesService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
