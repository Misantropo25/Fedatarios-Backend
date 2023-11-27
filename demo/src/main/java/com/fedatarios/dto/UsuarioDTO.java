package com.fedatarios.dto;

import com.fedatarios.model.Usuario;

import java.util.Date;

public class UsuarioDTO {
    private Long idUsuario;
    private String dni;
    private String apePaterno;
    private String apeMaterno;
    private String nombre;
    private String email;
    private String telefono;
    private String foto;
    private String descripcionRol; // Descripción del rol
    private Date fechaInicio;

    public UsuarioDTO(Long idUsuario, String dni, String apePaterno, String apeMaterno, String nombre, String email, String telefono, String foto, String descripcionRol, Date fechaInicio) {
        this.idUsuario = idUsuario;
        this.dni = dni;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.foto = foto;
        this.descripcionRol = descripcionRol;
        this.fechaInicio = fechaInicio;
    }

    public UsuarioDTO() {
    }


    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDescripcionRol() {
        return descripcionRol;
    }

    public void setDescripcionRol(String descripcionRol) {
        this.descripcionRol = descripcionRol;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
