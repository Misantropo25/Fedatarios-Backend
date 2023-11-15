package com.fedatarios.service;

import com.fedatarios.model.Usuario;
import com.fedatarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuariosService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> authenticate(String user, String password) {
        // Aquí deberías verificar la contraseña, posiblemente usando un PasswordEncoder
        return usuarioRepository.findByUser(user);
    }
	
	
}
