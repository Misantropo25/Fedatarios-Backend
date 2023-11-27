package com.fedatarios.controller;

import com.fedatarios.model.Rol;
import com.fedatarios.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    private final RolService rolService;

    @Autowired
    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping("/getRoles")
    public List<Rol> getAllRoles() {
        return rolService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> getRolById(@PathVariable Long id) {
        return rolService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public Rol createRol(@RequestBody Rol rol) {
        return rolService.save(rol);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> updateRol(@PathVariable Long id, @RequestBody Rol rolDetails) {
        return rolService.findById(id)
                .map(rol -> {
                    rol.setDescripcion_rol(rolDetails.getDescripcion_rol());
                    // Aquí puedes agregar más campos para actualizar si es necesario
                    Rol updatedRol = rolService.save(rol);
                    return ResponseEntity.ok(updatedRol);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRol(@PathVariable Long id) {
        Optional<Rol> rolOptional = rolService.findById(id);
        if (rolOptional.isPresent()) {
            Rol rol = rolOptional.get();
            // Aquí verificas si el rol tiene usuarios asociados
            if (!rol.getUsuarios().isEmpty()) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Este rol le pertenece a varios usuarios, borre los usuarios para eliminar el rol");
            }
            rolService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
