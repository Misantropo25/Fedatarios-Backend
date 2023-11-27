package com.fedatarios.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "documentos_escaneados")
public class Documentos_Escaneados {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iddoc_escaneado;

	@ManyToOne
	@JoinColumn(name = "idtipo_documento")
	@JsonBackReference
	private TipoDocumento tipo_documento;

	@Column(name = "ruta_archivo")
	private String rutaArchivo; // o nombreArchivo

	// Consideraciones en caso de que el docuemento este firmado
	@Column(name = "ruta_archivo_firmado")
	private String rutaArchivoFirmado;

	@Column(name = "firmado")
	private Boolean firmado;
	
	@ManyToOne
	@JoinColumn(name = "idlegajo")
	Legajo legajo;

	@OneToMany(mappedBy = "documentoEscaneado")
	private List<DocumentoObservacion> documentoObservaciones;


	// constructores

	public Documentos_Escaneados(Long iddoc_escaneado, TipoDocumento tipo_documento, String rutaArchivo, String rutaArchivoFirmado, Boolean firmado, Legajo legajo, List<DocumentoObservacion> documentoObservaciones) {
		this.iddoc_escaneado = iddoc_escaneado;
		this.tipo_documento = tipo_documento;
		this.rutaArchivo = rutaArchivo;
		this.rutaArchivoFirmado = rutaArchivoFirmado;
		this.firmado = firmado;
		this.legajo = legajo;
		this.documentoObservaciones = documentoObservaciones;
	}

	public Documentos_Escaneados() {
	}

	//getters y setters

	public String getRutaArchivoFirmado() {
		return rutaArchivoFirmado;
	}

	public void setRutaArchivoFirmado(String rutaArchivoFirmado) {
		this.rutaArchivoFirmado = rutaArchivoFirmado;
	}

	public Boolean getFirmado() {
		return firmado;
	}

	public void setFirmado(Boolean firmado) {
		this.firmado = firmado;
	}

	public Long getIddoc_escaneado() {
		return iddoc_escaneado;
	}

	public void setIddoc_escaneado(Long iddoc_escaneado) {
		this.iddoc_escaneado = iddoc_escaneado;
	}

	public TipoDocumento getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(TipoDocumento tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public Legajo getLegajo() {
		return legajo;
	}

	public void setLegajo(Legajo legajo) {
		this.legajo = legajo;
	}

	public void setDescripcion(String filename){
		this.tipo_documento.setDescripcion(filename);
	}

	public void getDescripcion(){
		this.tipo_documento.getDescripcion();
	}

	public List<DocumentoObservacion> getDocumentoObservaciones() {
		return documentoObservaciones;
	}

	public void setDocumentoObservaciones(List<DocumentoObservacion> documentoObservaciones) {
		this.documentoObservaciones = documentoObservaciones;
	}

	public String getRutaArchivo() {
		return rutaArchivo;
	}

	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}
}
