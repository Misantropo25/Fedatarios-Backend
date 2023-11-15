package com.fedatarios.controller;

import com.fedatarios.dto.ApiResponse;
import com.fedatarios.dto.LoginRequest;
import com.fedatarios.dto.LoginResponse;
import com.fedatarios.dto.SignUpRequest;
import com.fedatarios.excepciones.AppException;
import com.fedatarios.model.Rol;
import com.fedatarios.model.Usuario;
import com.fedatarios.repository.RolRepository;
import com.fedatarios.repository.UsuarioRepository;
import com.fedatarios.security.JwtTokenProvider;
import com.fedatarios.security.UserPrincipal;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioRepository userRepository;

    @Autowired
    RolRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        UserPrincipal userDetails = (UserPrincipal) authentication.getPrincipal();

        LoginResponse response = new LoginResponse();
        response.setToken(jwt);
        response.setId(userDetails.getId());
        response.setUsername(userDetails.getUsername());
        response.setEmail(userDetails.getEmail());
        response.setRoles(userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList()));

        return ResponseEntity.ok(response);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUser())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Crear cuenta de usuario
        Usuario user = new Usuario();
        user.setNombre(signUpRequest.getUser());
        user.setUser(signUpRequest.getUser());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        // Asignar rol por defecto o según el que venga en el DTO
        Rol userRole = roleRepository.findByDescripcion_rol(RoleName.ROLE_USER)
                .orElseThrow(() -> new AppException("User Role not set."));
        user.setIdrol(Collections.singleton(userRole));

        Usuario result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.getUser()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }
}