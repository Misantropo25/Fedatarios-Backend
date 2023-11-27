package com.fedatarios.controller;

import com.fedatarios.model.ReservaHorario;
import com.fedatarios.service.ReservaHorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reservaHorario")
public class ReservaHorarioController {

    private final ReservaHorarioService reservaHorarioService;

    @Autowired
    public ReservaHorarioController(ReservaHorarioService reservaHorarioService) {
        this.reservaHorarioService = reservaHorarioService;
    }

    @GetMapping
    public List<ReservaHorario> getAllReservas() {
        return reservaHorarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaHorario> getReservaById(@PathVariable Long id) {
        return reservaHorarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ReservaHorario createReserva(@RequestBody ReservaHorario reservaHorario) {
        return reservaHorarioService.save(reservaHorario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaHorario> updateReserva(@PathVariable Long id, @RequestBody ReservaHorario reservaDetails) {
        return reservaHorarioService.findById(id)
                .map(reserva -> {
                    reserva.setHorario(reservaDetails.getHorario());
                    reserva.setUsuario(reservaDetails.getUsuario());
                    reserva.setConfirmada(reservaDetails.isConfirmada());
                    ReservaHorario updatedReserva = reservaHorarioService.save(reserva);
                    return ResponseEntity.ok(updatedReserva);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReserva(@PathVariable Long id) {
        if (reservaHorarioService.findById(id).isPresent()) {
            reservaHorarioService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}