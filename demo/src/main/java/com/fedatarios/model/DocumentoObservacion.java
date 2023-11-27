package com.fedatarios.model;

import jakarta.persistence.*;

@Entity
@Table(name = "documento_observacion")
public class DocumentoObservacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "iddoc_escaneado")
    private Documentos_Escaneados documentoEscaneado;

    @ManyToOne
    @JoinColumn(name = "idobservacion")
    private Observaciones observacion;

    // Constructores

    public DocumentoObservacion() {
    }

    public DocumentoObservacion(Long id, Documentos_Escaneados documentoEscaneado, Observaciones observacion) {
        this.id = id;
        this.documentoEscaneado = documentoEscaneado;
        this.observacion = observacion;
    }

    // Getters, setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Documentos_Escaneados getDocumentoEscaneado() {
        return documentoEscaneado;
    }

    public void setDocumentoEscaneado(Documentos_Escaneados documentoEscaneado) {
        this.documentoEscaneado = documentoEscaneado;
    }

    public Observaciones getObservacion() {
        return observacion;
    }

    public void setObservacion(Observaciones observacion) {
        this.observacion = observacion;
    }
}
