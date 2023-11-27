package com.fedatarios.dto;

public class LoginRequest {
    private String dni;
    private String password;
    // Getters y setters

    public LoginRequest(String dni, String password) {
        this.dni = dni;
        this.password = password;
    }

    public LoginRequest() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

