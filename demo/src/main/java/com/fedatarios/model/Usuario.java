package com.fedatarios.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idusuario;

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

	@Column(name = "username", length = 100)
	private String user;

	@OneToOne
	@Nullable
	@JoinColumn(name = "idrol")
	private Rol idrol;

	@Column(name = "fechaInicio")
	@Temporal(TemporalType.TIMESTAMP) // o TemporalType.DATE según lo que necesites
	private Date fechaInicio;

	@OneToMany(mappedBy = "usuario")
	List<Horarios> horariosList;
	
	@OneToMany(mappedBy = "usuario")
	List<Legajo> legajoList;
	
	@OneToMany(mappedBy = "usuario")
	List<UsuarioDeclaracionesJuradas> usuariodj;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
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

	public void setApePaterno(String ape_paterno) {
		this.apePaterno = ape_paterno;
	}

	public String getApeMaterno() {
		return apeMaterno;
	}

	public void setApeMaterno(String ape_materno) {
		this.apeMaterno = ape_materno;
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

	public Rol getIdrol() {
		return idrol;
	}



	public void setIdrol(Rol idrol) {
		this.idrol = idrol;
	}

	public Date getFecha_inicio() {
		return new java.sql.Date(this.fechaInicio.getTime());
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fechaInicio = fecha_inicio;
	}

	public List<Horarios> getHorariosList() {
		return horariosList;
	}

	public void setHorariosList(List<Horarios> horariosList) {
		this.horariosList = horariosList;
	}

	public Usuario(Long idusuario, String dni, String ape_paterno, String ape_materno, String nombre, String email,
				   String telefono, Rol idrol, Date fecha_inicio, List<Horarios> horariosList, String user) {
		super();
		this.idusuario = idusuario;
		this.dni = dni;
		this.apePaterno = ape_paterno;
		this.apeMaterno = ape_materno;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.idrol = idrol;
		this.fechaInicio = fecha_inicio;
		this.horariosList = horariosList;
		this.user = user;
	}

	public Usuario() {
		super();
	}

}
