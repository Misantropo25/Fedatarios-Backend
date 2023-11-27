package com.fedatarios.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Rol {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idrol;

	 private String descripcion_rol;

	@OneToMany(mappedBy = "rol")
	@JsonManagedReference
	private List<Usuario> usuarios;

	 //constructores

	public Rol(Long idrol, String descripcion_rol, List<Usuario> usuarios) {
		this.idrol = idrol;
		this.descripcion_rol = descripcion_rol;
		this.usuarios = usuarios;
	}

	public Rol() {
	}

	//getters y setters

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

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



}
