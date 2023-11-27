package com.fedatarios.dto;

public class AuthenticationResponse {
    private String jwt;
    private Long userId;
    private String userDni;

    public AuthenticationResponse(String jwt, Long userId, String userDni) {
        this.jwt = jwt;
        this.userId = userId;
        this.userDni = userDni;
    }

    public AuthenticationResponse() {
    }
    // Getters y setters


    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserDni() {
        return userDni;
    }

    public void setUserDni(String userDni) {
        this.userDni = userDni;
    }
}

