package com.fedatarios.security;

import com.fedatarios.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserPrincipal implements UserDetails {

    private final Usuario usuario;

    public UserPrincipal(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Aquí podrías asignar los roles o permisos del usuario si los tienes.
        // Por simplicidad, estamos asignando un rol genérico.
        return Collections.singleton(() -> "ROLE_USER");
    }

    @Override
    public String getPassword() {
        return usuario.getPassword();
    }

    @Override
    public String getUsername() {
        return usuario.getDni();
    }

    @Override
    public boolean isAccountNonExpired() {
        // Aquí puedes agregar la lógica para determinar si la cuenta ha expirado.
        // Por ejemplo, verificar una fecha de expiración en la entidad Usuario.
        // Por defecto, vamos a retornar true (la cuenta no ha expirado).
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Aquí puedes agregar la lógica para determinar si la cuenta está bloqueada.
        // Por ejemplo, podrías tener una bandera en la entidad Usuario.
        // Por defecto, vamos a retornar true (la cuenta no está bloqueada).
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Aquí puedes agregar lógica para verificar si las credenciales han expirado.
        // Por ejemplo, podrías verificar la fecha de cambio de contraseña.
        // Por defecto, vamos a retornar true (las credenciales no han expirado).
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Aquí puedes agregar lógica para determinar si el usuario está habilitado.
        // Por ejemplo, podrías tener una bandera en la entidad Usuario.
        // Por defecto, vamos a retornar true (el usuario está habilitado).
        return true;
    }
}