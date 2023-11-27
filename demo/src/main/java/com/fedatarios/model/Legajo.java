package com.fedatarios.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="legajos")

public class Legajo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idlegajo;
	
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name = "idusuario")
	@JsonBackReference
	private Usuario usuario;
	
	@OneToMany(mappedBy = "legajo")
	List<Documentos_Escaneados> docEscaneados;

	public Long getIdlegajo() {
		return idlegajo;
	}

	public void setIdlegajo(Long idlegajo) {
		this.idlegajo = idlegajo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Documentos_Escaneados> getDocEscaneados() {
		return docEscaneados;
	}

	public void setDocEscaneados(List<Documentos_Escaneados> docEscaneados) {
		this.docEscaneados = docEscaneados;
	}

	public Legajo(Long idlegajo, Date fecha, Usuario usuario, List<Documentos_Escaneados> docEscaneados) {
		super();
		this.idlegajo = idlegajo;
		this.fecha = fecha;
		this.usuario = usuario;
		this.docEscaneados = docEscaneados;
	}

	public Legajo() {
		super();
	}
	
	
}
