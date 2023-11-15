package com.fedatarios.service;

import com.fedatarios.dto.RegistrationRequest;
import com.fedatarios.model.Usuario;
import com.fedatarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.fedatarios.model.Usuario;
import com.fedatarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AuthService(UsuarioRepository usuarioRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUser(user)
                .orElseThrow(() -> new UsernameNotFoundException("No user found with email: " + user));

        return new User(usuario.getUser(), usuario.getPassword(), Collections.emptyList());
        // Aquí se devuelven las autoridades vacías, pero podrías añadir lógica para cargar roles o permisos.
    }

    public Usuario register(RegistrationRequest registrationRequest) {
        // Crear una nueva instancia de Usuario y establecer sus propiedades desde RegistrationRequest
        Usuario usuario = new Usuario();
        usuario.setDni(registrationRequest.getDni());
        usuario.setApePaterno(registrationRequest.getApePaterno());
        usuario.setApeMaterno(registrationRequest.getApeMaterno());
        usuario.setNombre(registrationRequest.getNombre());
        usuario.setEmail(registrationRequest.getEmail());
        usuario.setTelefono(registrationRequest.getTelefono());
        usuario.setUser(registrationRequest.getUser());
        usuario.setPassword(bCryptPasswordEncoder.encode(registrationRequest.getPassword()));
        usuario.setFecha_inicio(registrationRequest.getFechaInicio());
        // Guardar el usuario en la base de datos
        return usuarioRepository.save(usuario);
    }


}
