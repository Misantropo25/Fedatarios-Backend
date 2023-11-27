package com.fedatarios.controller;

import com.fedatarios.model.HorarioFedatario;
import com.fedatarios.model.Usuario;
import com.fedatarios.service.HorarioFedatarioService;
import com.fedatarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/horarios-fedatarios")
public class HorarioFedatarioController {

    @Autowired
    private HorarioFedatarioService horarioFedatarioService;

    @Autowired
    private UsuarioService usuarioService;

    // Endpoint para crear un único horario
    @PostMapping("/single")
    public ResponseEntity<?> createHorarioFedatario(@RequestBody HorarioFedatario horarioFedatario) {
        return processHorarioFedatario(Collections.singletonList(horarioFedatario));
    }

    // Endpoint para crear múltiples horarios
    @PostMapping
    public ResponseEntity<?> createHorariosFedatarios(@RequestBody List<HorarioFedatario> horariosFedatarios) {
        return processHorarioFedatario(horariosFedatarios);
    }

    public ResponseEntity<?> processHorarioFedatario(List<HorarioFedatario> horarios) {
        List<HorarioFedatario> horariosGuardados = new ArrayList<>();

        for (HorarioFedatario horario : horarios) {
            // Validar que el usuario exista y sea un fedatario
            Usuario usuario = usuarioService.findById(horario.getUsuario().getIdUsuario())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

            if (!usuario.getRol().getDescripcion_rol().equals("Fedator")) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("El usuario no es un fedatario");
            }

            // Validar horas (asegúrate de que HorarioFedatario tenga getters para horaInicio y horaFin)
            if (horario.getHoraInicio().isAfter(horario.getHoraFin())) {
                return ResponseEntity.badRequest().body("La hora de inicio debe ser anterior a la hora de fin");
            }

            // Validar fecha (asumiendo que getFecha devuelve un objeto LocalDate)
            if (horario.getFecha().isBefore(LocalDate.now())) {
                return ResponseEntity.badRequest().body("La fecha no puede ser anterior a la fecha actual");
            }

            // Validar día de la semana
            DayOfWeek dayOfWeek = horario.getFecha().getDayOfWeek();
            String expectedDay = dayOfWeek.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
            if (!horario.getDiaSemana().equalsIgnoreCase(expectedDay)) {
                return ResponseEntity.badRequest().body("El día de la semana no coincide con la fecha");
            }

            // Guardar el horario
            HorarioFedatario horarioGuardado = horarioFedatarioService.save(horario);
            horariosGuardados.add(horarioGuardado);
        }

        return ResponseEntity.ok(horariosGuardados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorarioFedatario> getHorarioFedatarioById(@PathVariable Long id) {
        return horarioFedatarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<HorarioFedatario> getAllHorariosFedatarios() {
        return horarioFedatarioService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorarioFedatario> updateHorarioFedatario(@PathVariable Long id, @RequestBody HorarioFedatario horarioFedatarioDetails) {
        return horarioFedatarioService.findById(id)
                .map(horarioFedatario -> {
                    horarioFedatario.setDiaSemana(horarioFedatarioDetails.getDiaSemana());
                    horarioFedatario.setHoraInicio(horarioFedatarioDetails.getHoraInicio());
                    horarioFedatario.setHoraFin(horarioFedatarioDetails.getHoraFin());
                    // Agrega otros campos si es necesario
                    return ResponseEntity.ok(horarioFedatarioService.save(horarioFedatario));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHorarioFedatario(@PathVariable Long id) {
        return horarioFedatarioService.findById(id)
                .map(horarioFedatario -> {
                    horarioFedatarioService.deleteById(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<HorarioFedatario>> getHorariosPorUsuarioId(@PathVariable Long usuarioId) {
        List<HorarioFedatario> horarios = horarioFedatarioService.findByUsuario_IdUsuario(usuarioId);
        if (horarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(horarios);
    }
}