package com.fedatarios.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="reservas_horarios")
public class ReservaHorario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    @ManyToOne
    @JoinColumn(name = "idHorario")
    @JsonBackReference
    private Horarios horario;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    private boolean confirmada; // Indica si la reserva está confirmada

    // Constructores
    public ReservaHorario() {
    }

    public ReservaHorario(Long idReserva, Horarios horario, Usuario usuario, boolean confirmada) {
        this.idReserva = idReserva;
        this.horario = horario;
        this.usuario = usuario;
        this.confirmada = confirmada;
    }

    // Getters y setters
    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public Horarios getHorario() {
        return horario;
    }

    public void setHorario(Horarios horario) {
        this.horario = horario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isConfirmada() {
        return confirmada;
    }

    public void setConfirmada(boolean confirmada) {
        this.confirmada = confirmada;
    }
}
