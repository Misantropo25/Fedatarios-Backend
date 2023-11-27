package com.fedatarios.model;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name="horarios")
public class Horarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idHorario")
    private Long idHorario;
	
    private LocalDateTime fecha_hora;

	@OneToMany(mappedBy = "horario")
	@JsonManagedReference
	private List<ReservaHorario> reservas;


	// constructores

	public Horarios() {
	}

	public Horarios(Long idHorario, LocalDateTime fecha_hora, List<ReservaHorario> reservas) {
		this.idHorario = idHorario;
		this.fecha_hora = fecha_hora;
		this.reservas = reservas;
	}

	//getters y setters

	public Long getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(Long idHorario) {
		this.idHorario = idHorario;
	}

	public List<ReservaHorario> getReservas() {
		return reservas;
	}

	public void setReservas(List<ReservaHorario> reservas) {
		this.reservas = reservas;
	}

	public Long getId() {
		return idHorario;
	}

	public void setId(Long idHorario) {
		this.idHorario = idHorario;
	}

	public LocalDateTime getFecha_hora() {
		return fecha_hora;
	}

	public void setFecha_hora(LocalDateTime fecha_hora) {
		this.fecha_hora = fecha_hora;
	}

	public LocalDateTime getFechaHora() {
		return fecha_hora;
	}

	public void setFechaHora(LocalDateTime fecha_hora) {
		this.fecha_hora = fecha_hora;
	}

}
