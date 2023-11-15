package com.fedatarios.model;

import java.sql.Time;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="horarios")
public class Horarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private Date fecha;
    
    private Time hora;
    
    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Horarios(Long id, Date fecha, Time hora, Usuario usuario) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.usuario = usuario;
	}

	public Horarios() {
		super();
	}

}
