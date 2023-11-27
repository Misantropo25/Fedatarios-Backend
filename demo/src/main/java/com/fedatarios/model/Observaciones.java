package com.fedatarios.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "observaciones")
public class Observaciones {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idobservaciones;

	private String descripcion;

	@OneToMany(mappedBy = "observacion")
	private List<DocumentoObservacion> documentoObservaciones;

	// Constructores

	public Observaciones() {
	}

	public Observaciones(Long idobservaciones, String descripcion, List<DocumentoObservacion> documentoObservaciones) {
		this.idobservaciones = idobservaciones;
		this.descripcion = descripcion;
		this.documentoObservaciones = documentoObservaciones;
	}

	// Getters y setters

	public List<DocumentoObservacion> getDocumentoObservaciones() {
		return documentoObservaciones;
	}

	public void setDocumentoObservaciones(List<DocumentoObservacion> documentoObservaciones) {
		this.documentoObservaciones = documentoObservaciones;
	}

	public Long getIdobservaciones() {
		return idobservaciones;
	}

	public void setIdobservaciones(Long idobservaciones) {
		this.idobservaciones = idobservaciones;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



}
