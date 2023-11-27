package com.fedatarios.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;

	@Column(name = "dni", length = 15)
	private String dni;

	@Column(name = "apePaterno", length = 50)
	private String apePaterno;

	@Column(name = "apeMaterno", length = 50)
	private String apeMaterno;

	@Column(name = "nombre", length = 50)
	private String nombre;

	@Column(name = "email", length = 250)
	private String email;

	@Column(name = "telefono", length = 50)
	private String telefono;

	@Column(name = "password", length = 100)
	private String password;

	@Column(name = "foto", length = 12000)
	private String foto;

	@ManyToOne
	@JoinColumn(name = "idrol")
	@JsonBackReference
	private Rol rol;

	@Column(name = "fechaInicio")
	@Temporal(TemporalType.TIMESTAMP) // o TemporalType.DATE según lo que necesites
	private Date fechaInicio;

	@OneToMany(mappedBy = "usuario")
	@JsonManagedReference
	List<Legajo> legajoList;

	@OneToMany(mappedBy = "usuario")
	List<UsuarioDeclaracionesJuradas> usuariodj;

	@OneToMany(mappedBy = "usuario")
	private List<ReservaHorario> reservasHorario;

	@OneToMany(mappedBy = "usuario")
	@JsonManagedReference
	private List<HorarioFedatario> horariosFedatario;

	//constructores


	public Usuario(Long idUsuario, String dni, String apePaterno, String apeMaterno, String nombre, String email, String telefono, String password, String foto, Rol rol, Date fechaInicio, List<Legajo> legajoList, List<UsuarioDeclaracionesJuradas> usuariodj, List<ReservaHorario> reservasHorario, List<HorarioFedatario> horariosFedatario) {
		this.idUsuario = idUsuario;
		this.dni = dni;
		this.apePaterno = apePaterno;
		this.apeMaterno = apeMaterno;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.password = password;
		this.foto = foto;
		this.rol = rol;
		this.fechaInicio = fechaInicio;
		this.legajoList = legajoList;
		this.usuariodj = usuariodj;
		this.reservasHorario = reservasHorario;
		this.horariosFedatario = horariosFedatario;
	}

	public Usuario() {
		super();
	}

	// getters y setters

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public List<HorarioFedatario> getHorariosFedatario() {
		return horariosFedatario;
	}

	public void setHorariosFedatario(List<HorarioFedatario> horariosFedatario) {
		this.horariosFedatario = horariosFedatario;
	}

	public List<ReservaHorario> getReservasHorario() {
		return reservasHorario;
	}

	public void setReservasHorario(List<ReservaHorario> reservasHorario) {
		this.reservasHorario = reservasHorario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Long getIdusuario() {
		return idUsuario;
	}

	public void setIdusuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApePaterno() {
		return apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}

	public String getApeMaterno() {
		return apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public List<Legajo> getLegajoList() {
		return legajoList;
	}

	public void setLegajoList(List<Legajo> legajoList) {
		this.legajoList = legajoList;
	}

	public List<UsuarioDeclaracionesJuradas> getUsuariodj() {
		return usuariodj;
	}

	public void setUsuariodj(List<UsuarioDeclaracionesJuradas> usuariodj) {
		this.usuariodj = usuariodj;
	}
}
