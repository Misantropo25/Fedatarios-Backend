package com.fedatarios.dto;

public class TipoDocumentoDTO {
    private Long idtipo_documento;
    private String descripcion;

    // Constructor, getters y setters
    public TipoDocumentoDTO() {}

    public TipoDocumentoDTO(Long idtipo_documento, String descripcion) {
        this.idtipo_documento = idtipo_documento;
        this.descripcion = descripcion;
    }

    // Getters y setters aquí


    public Long getIdtipo_documento() {
        return idtipo_documento;
    }

    public void setIdtipo_documento(Long idtipo_documento) {
        this.idtipo_documento = idtipo_documento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}