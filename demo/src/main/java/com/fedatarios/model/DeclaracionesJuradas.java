package com.fedatarios.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "declaraciones_juradas")
public class DeclaracionesJuradas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iddeclaracion;
	
	private String descripcion;
	
	@OneToMany(mappedBy = "dj")
	@JsonManagedReference
	List<UsuarioDeclaracionesJuradas> usuariodj;

	public Long getIddeclaracion() {
		return iddeclaracion;
	}

	public void setIddeclaracion(Long iddeclaracion) {
		this.iddeclaracion = iddeclaracion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<UsuarioDeclaracionesJuradas> getUsuariodj() {
		return usuariodj;
	}

	public void setUsuariodj(List<UsuarioDeclaracionesJuradas> usuariodj) {
		this.usuariodj = usuariodj;
	}

	public DeclaracionesJuradas(Long iddeclaracion, String descripcion, List<UsuarioDeclaracionesJuradas> usuariodj) {
		super();
		this.iddeclaracion = iddeclaracion;
		this.descripcion = descripcion;
		this.usuariodj = usuariodj;
	}

	public DeclaracionesJuradas() {
		super();
	}
		
}
