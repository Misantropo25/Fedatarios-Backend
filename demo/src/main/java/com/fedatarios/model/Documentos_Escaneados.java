package com.fedatarios.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "documentos_escaneados")
public class Documentos_Escaneados {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iddoc_escaneado;
	
	@OneToOne
	@JoinColumn(name = "idtipo_documento")
	private TipoDocumento tipo_documento;
	
	@ManyToOne
	@JoinColumn(name = "idlegajo")
	Legajo legajo;
	
	@OneToMany(mappedBy = "docEscaneados")
	List<Observaciones> listaObservaciones;

	public Long getIddoc_escaneado() {
		return iddoc_escaneado;
	}

	public void setIddoc_escaneado(Long iddoc_escaneado) {
		this.iddoc_escaneado = iddoc_escaneado;
	}

	public TipoDocumento getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(TipoDocumento tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public Legajo getLegajo() {
		return legajo;
	}

	public void setLegajo(Legajo legajo) {
		this.legajo = legajo;
	}

	public List<Observaciones> getListaObservaciones() {
		return listaObservaciones;
	}

	public void setListaObservaciones(List<Observaciones> listaObservaciones) {
		this.listaObservaciones = listaObservaciones;
	}

	public Documentos_Escaneados(Long iddoc_escaneado, TipoDocumento tipo_documento, Legajo legajo,
			List<Observaciones> listaObservaciones) {
		super();
		this.iddoc_escaneado = iddoc_escaneado;
		this.tipo_documento = tipo_documento;
		this.legajo = legajo;
		this.listaObservaciones = listaObservaciones;
	}

	public Documentos_Escaneados() {
		super();
	}

}
