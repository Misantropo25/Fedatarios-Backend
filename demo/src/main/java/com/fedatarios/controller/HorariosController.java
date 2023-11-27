package com.fedatarios.controller;

import com.fedatarios.model.Horarios;
import com.fedatarios.service.HorariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/horarios")
public class HorariosController {

    private final HorariosService horariosService;

    @Autowired
    public HorariosController(HorariosService horariosService) {
        this.horariosService = horariosService;
    }

    @GetMapping
    public List<Horarios> getAllHorarios() {
        return horariosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horarios> getHorarioById(@PathVariable Long id) {
        return horariosService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Horarios createHorario(@RequestBody Horarios horario) {
        return horariosService.save(horario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Horarios> updateHorario(@PathVariable Long id, @RequestBody Horarios horarioDetails) {
        return horariosService.findById(id)
                .map(horario -> {
                    horario.setFechaHora(horarioDetails.getFechaHora());
                    Horarios updatedHorario = horariosService.save(horario);
                    return ResponseEntity.ok(updatedHorario);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHorario(@PathVariable Long id) {
        if (horariosService.findById(id).isPresent()) {
            horariosService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
