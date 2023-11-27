package com.fedatarios.controller;

import com.fedatarios.model.Legajo;
import com.fedatarios.service.LegajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/legajo")
public class LegajoController {

    private final LegajoService legajoService;

    @Autowired
    public LegajoController(LegajoService legajoService) {
        this.legajoService = legajoService;
    }

    @GetMapping
    public List<Legajo> getAllLegajos() {
        return legajoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Legajo> getLegajoById(@PathVariable Long id) {
        return legajoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Legajo createLegajo(@RequestBody Legajo legajo) {
        return legajoService.save(legajo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Legajo> updateLegajo(@PathVariable Long id, @RequestBody Legajo legajoDetails) {
        return legajoService.findById(id)
                .map(legajo -> {
                    legajo.setFecha(legajoDetails.getFecha());
                    legajo.setUsuario(legajoDetails.getUsuario());
                    legajo.setDocEscaneados(legajoDetails.getDocEscaneados());
                    Legajo updatedLegajo = legajoService.save(legajo);
                    return ResponseEntity.ok(updatedLegajo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLegajo(@PathVariable Long id) {
        if (legajoService.findById(id).isPresent()) {
            legajoService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}