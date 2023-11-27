package com.fedatarios.dto;

public class DatosReniec {
    private String dni;
    private String apPrimer;
    private String apSegundo;
    private String direccion;
    private String estadoCivil;
    private String foto;
    private String prenombres;
    private String restriccion;
    private String ubigeo;
    private String telefono;
    private String correo;

    public DatosReniec() {
    }

    public DatosReniec(String dni, String apPrimer, String apSegundo, String direccion, String estadoCivil, String foto, String prenombres, String restriccion, String ubigeo, String telefono, String correo) {
        this.dni = dni;
        this.apPrimer = apPrimer;
        this.apSegundo = apSegundo;
        this.direccion = direccion;
        this.estadoCivil = estadoCivil;
        this.foto = foto;
        this.prenombres = prenombres;
        this.restriccion = restriccion;
        this.ubigeo = ubigeo;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApPrimer() {
        return apPrimer;
    }

    public void setApPrimer(String apPrimer) {
        this.apPrimer = apPrimer;
    }

    public String getApSegundo() {
        return apSegundo;
    }

    public void setApSegundo(String apSegundo) {
        this.apSegundo = apSegundo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getPrenombres() {
        return prenombres;
    }

    public void setPrenombres(String prenombres) {
        this.prenombres = prenombres;
    }

    public String getRestriccion() {
        return restriccion;
    }

    public void setRestriccion(String restriccion) {
        this.restriccion = restriccion;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}