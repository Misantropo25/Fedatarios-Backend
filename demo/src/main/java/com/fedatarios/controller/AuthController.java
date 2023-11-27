package com.fedatarios.controller;

import com.fedatarios.dto.AuthenticationResponse;
import com.fedatarios.dto.LoginRequest;
import com.fedatarios.model.Usuario;
import com.fedatarios.repository.UsuarioRepository;
import com.fedatarios.security.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    public AuthController(AuthenticationManager authenticationManager, UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil, UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getDni(), loginRequest.getPassword())
            );
        } catch (AuthenticationException e) {
            e.printStackTrace(); // Agrega esto para imprimir el stack trace
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getDni());
        final String jwt = jwtUtil.generateToken(userDetails);

        // Obtén el usuario de la base de datos
        Usuario usuario = usuarioRepository.findByDni(loginRequest.getDni())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Crea el objeto de respuesta con el token y la información adicional
        AuthenticationResponse response = new AuthenticationResponse();
        response.setJwt(jwt);
        response.setUserId(usuario.getIdUsuario());
        response.setUserDni(usuario.getDni());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Usuario usuario) {
        // Verifica si ya existe un usuario con el mismo DNI
        if (usuarioRepository.findByDni(usuario.getDni()).isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Ya existe un usuario con el DNI proporcionado");
        }

        // Aquí continúa tu lógica de registro existente...
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuario registrado exitosamente");
    }
}
