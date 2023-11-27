package com.fedatarios.dto;

public class DocumentosEscaneadosDTO {
    private Long id;
    private String rutaArchivo;
    private String rutaArchivoFirmado;
    private Boolean firmado;
    private Long tipoDocumentoId;
    private Long legajoId;

    //constructores

    public DocumentosEscaneadosDTO(Long id, String rutaArchivo, String rutaArchivoFirmado, Boolean firmado, Long tipoDocumentoId, Long legajoId) {
        this.id = id;
        this.rutaArchivo = rutaArchivo;
        this.rutaArchivoFirmado = rutaArchivoFirmado;
        this.firmado = firmado;
        this.tipoDocumentoId = tipoDocumentoId;
        this.legajoId = legajoId;
    }

    public DocumentosEscaneadosDTO() {
    }
    //getters y setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public String getRutaArchivoFirmado() {
        return rutaArchivoFirmado;
    }

    public void setRutaArchivoFirmado(String rutaArchivoFirmado) {
        this.rutaArchivoFirmado = rutaArchivoFirmado;
    }

    public Boolean getFirmado() {
        return firmado;
    }

    public void setFirmado(Boolean firmado) {
        this.firmado = firmado;
    }

    public Long getTipoDocumentoId() {
        return tipoDocumentoId;
    }

    public void setTipoDocumentoId(Long tipoDocumentoId) {
        this.tipoDocumentoId = tipoDocumentoId;
    }

    public Long getLegajoId() {
        return legajoId;
    }

    public void setLegajoId(Long legajoId) {
        this.legajoId = legajoId;
    }
}
