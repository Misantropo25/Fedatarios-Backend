package com.fedatarios.dto;

import com.fedatarios.model.Usuario;

import java.sql.Date;
import java.util.zip.DataFormatException;

public class RegistrationResponse {
    private Long idusuario;
    private String dni;
    private String apePaterno;
    private String apeMaterno;
    private String nombre;
    private String email;
    private String telefono;
    private String username;
    private java.util.Date fechaInicio;

    // Constructor que toma un Usuario y lo convierte en un RegistrationResponse
    public RegistrationResponse(Usuario usuario) {
        this.idusuario = usuario.getIdusuario();
        this.dni = usuario.getDni();
        this.apePaterno = usuario.getApePaterno();
        this.apeMaterno = usuario.getApeMaterno();
        this.nombre = usuario.getNombre();
        this.email = usuario.getEmail();
        this.telefono = usuario.getTelefono();
        this.username = usuario.getUser();
        this.fechaInicio = usuario.getFecha_inicio();
    }

    // Constructor
    public RegistrationResponse(Long idusuario, String dni, String apePaterno, String apeMaterno,
                                String nombre, String email, String telefono, String user,  java.sql.Date fechaInicio) {
        this.idusuario = idusuario;
        this.dni = dni;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.username = user;
        this.fechaInicio = fechaInicio;
    }

    //Constructor
    public RegistrationResponse(Long idusuario, String user) {
        this.idusuario = idusuario;
        this.username = user;
    }

    // Getters y posiblemente setters si son necesarios

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUser() {
        return username;
    }

    public void setUser(String user) {
        this.username = user;
    }

    public Long getIdusuario() {
        return idusuario;
    }

    public Date getFechaInicio() {
        return (Date) fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
