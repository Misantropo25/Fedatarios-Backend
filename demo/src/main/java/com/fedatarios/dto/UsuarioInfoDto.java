package com.fedatarios.dto;

public class UsuarioInfoDto {
    private Long id;
    private String dni;
    private String token;

    public UsuarioInfoDto() {
    }

    public UsuarioInfoDto(Long id, String dni, String token) {
        this.id = id;
        this.dni = dni;
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
