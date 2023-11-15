package com.fedatarios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Rol {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idrol;

	 private String descripcion_rol;

	 @OneToOne(mappedBy = "idrol")
	 private Usuario usuario;

	public Long getIdrol() {
		return idrol;
	}

	public void setIdrol(Long idrol) {
		this.idrol = idrol;
	}

	public String getDescripcion_rol() {
		return descripcion_rol;
	}

	public void setDescripcion_rol(String descripcion_rol) {
		this.descripcion_rol = descripcion_rol;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Rol() {
		super();
	}
	
	 
	 
}
