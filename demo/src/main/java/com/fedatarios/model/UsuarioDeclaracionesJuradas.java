package com.fedatarios.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario_declaracione_juradas")
public class UsuarioDeclaracionesJuradas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idusuariodj;
	
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "iddeclaracion")
	@JsonBackReference
	DeclaracionesJuradas dj;

	public Long getIdusuriodj() {
		return idusuariodj;
	}

	public void setIdusuriodj(Long idusuriodj) {
		this.idusuariodj = idusuriodj;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public DeclaracionesJuradas getDj() {
		return dj;
	}

	public void setDj(DeclaracionesJuradas dj) {
		this.dj = dj;
	}

	public UsuarioDeclaracionesJuradas(Long idusuriodj, Usuario usuario, DeclaracionesJuradas dj) {
		super();
		this.idusuariodj = idusuriodj;
		this.usuario = usuario;
		this.dj = dj;
	}

	public UsuarioDeclaracionesJuradas() {
		super();
	}
	
}
