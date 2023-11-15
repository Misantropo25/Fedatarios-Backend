package com.fedatarios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "observaciones")
public class Observaciones {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idobservaciones;
	
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "iddoc_escaneado")
	Documentos_Escaneados docEscaneados;

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

	public Documentos_Escaneados getDocEscaneados() {
		return docEscaneados;
	}

	public void setDocEscaneados(Documentos_Escaneados docEscaneados) {
		this.docEscaneados = docEscaneados;
	}

	public Observaciones(Long idobservaciones, String descripcion, Documentos_Escaneados docEscaneados) {
		super();
		this.idobservaciones = idobservaciones;
		this.descripcion = descripcion;
		this.docEscaneados = docEscaneados;
	}

	public Observaciones() {
		super();
	}
	
}
