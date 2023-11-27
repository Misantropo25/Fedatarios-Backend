package com.fedatarios.controller;

import com.fedatarios.dto.DatosReniec;
import com.fedatarios.dto.UsuarioDTO;
import com.fedatarios.model.HorarioFedatario;
import com.fedatarios.model.Rol;
import com.fedatarios.model.Usuario;
import com.fedatarios.repository.UsuarioRepository;
import com.fedatarios.service.DatosReniecService;
import com.fedatarios.service.HorarioFedatarioService;
import com.fedatarios.service.RolService;
import com.fedatarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final RolService rolService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private HorarioFedatarioService horarioFedatarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(PasswordEncoder passwordEncoder, UsuarioService usuarioService,RolService rolService) {
        this.usuarioService = usuarioService;
        this.rolService = rolService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/usuario_list")
    public List<Usuario> getAllUsuarios() {
        return usuarioService.findAll();
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
//        return usuarioService.findById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable Long id) {
        return usuarioRepository.findById(id)
                .map(this::convertirAUsuarioDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    // Manejo de DTO para modificacion de respuesta al buscar usuario por id
    private UsuarioDTO convertirAUsuarioDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setIdUsuario(usuario.getIdUsuario());
        dto.setDni(usuario.getDni());
        dto.setApePaterno(usuario.getApePaterno());
        dto.setApeMaterno(usuario.getApeMaterno());
        dto.setNombre(usuario.getNombre());
        dto.setEmail(usuario.getEmail());
        dto.setTelefono(usuario.getTelefono());
        dto.setFoto(usuario.getFoto());
        if (usuario.getRol() != null) {
            dto.setDescripcionRol(usuario.getRol().getDescripcion_rol());
        }
        dto.setFechaInicio(usuario.getFechaInicio());
        return dto;
    }

    @PostMapping(value = "/create_usuario", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createUsuario(@RequestBody Usuario usuario) {
        System.out.println(usuario);
        // Verificar si el DNI ya existe
        if (usuarioRepository.findByDni(usuario.getDni()).isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Ya existe un usuario con el DNI proporcionado");
        }

        // Encuentra el rol por ID y lo asigna al usuario
        Rol rol = rolService.findById(usuario.getRol().getIdrol())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        usuario.setRol(rol);

        // Encriptar la contraseña
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        //Guardar la foto
        // Asignar la URL de la foto correctamente
        usuario.setFoto(usuario.getFoto());
        // Guardar usuario
        usuario.setFechaInicio(new Date()); // Establece la fecha actual
        Usuario savedUsuario = usuarioService.save(usuario);
        return ResponseEntity.ok("Usuario registrado exitosamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetails) {
        return usuarioService.findById(id)
                .map(usuario -> {
                    //usuario.setDni(usuarioDetails.getDni());
                    usuario.setApePaterno(usuarioDetails.getApePaterno());
                    usuario.setApeMaterno(usuarioDetails.getApeMaterno());
                    usuario.setNombre(usuarioDetails.getNombre());
                    usuario.setEmail(usuarioDetails.getEmail());
                    usuario.setTelefono(usuarioDetails.getTelefono());

                    // Actualizar la contraseña solo si se envía una nueva
                    if (usuarioDetails.getPassword() != null && !usuarioDetails.getPassword().isEmpty()) {
                        usuario.setPassword(passwordEncoder.encode(usuarioDetails.getPassword()));
                    }

                    usuario.setRol(usuarioDetails.getRol());
                    //usuario.setFechaInicio(usuarioDetails.getFechaInicio());
                    //Agrega cualquier otro campo que necesites actualizar
                    Usuario updatedUsuario = usuarioService.save(usuario);
                    return ResponseEntity.ok(updatedUsuario);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable Long id) {
        if (usuarioService.findById(id).isPresent()) {
            usuarioService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Endpoints fedatario
    @PostMapping("/{usuarioId}/horarios")
    public ResponseEntity<HorarioFedatario> agregarHorario(@PathVariable Long usuarioId, @RequestBody HorarioFedatario horario) {
        Usuario usuario = usuarioService.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        horario.setUsuario(usuario);
        HorarioFedatario nuevoHorario = horarioFedatarioService.save(horario);
        return ResponseEntity.ok(nuevoHorario);
    }

    @GetMapping("/{usuarioId}/horarios")
    public ResponseEntity<List<HorarioFedatario>> obtenerHorarios(@PathVariable Long usuarioId) {
        List<HorarioFedatario> horarios = horarioFedatarioService.findByUsuario_IdUsuario(usuarioId);
        return ResponseEntity.ok(horarios);
    }


    // Datos Reniec para registro de usuarios
    @Autowired
    private DatosReniecService datosReniecService;

    @GetMapping("/datos-reniec/{dni}")
    public ResponseEntity<?> obtenerDatosPorDNI(@PathVariable String dni) {
        Optional<DatosReniec> datosReniecOpt = datosReniecService.obtenerDatosPorDNI(dni);
        if (datosReniecOpt.isPresent()) {
            return ResponseEntity.ok(datosReniecOpt.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Datos no encontrados para el DNI proporcionado");
        }
    }
}
