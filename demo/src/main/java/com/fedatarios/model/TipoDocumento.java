package com.fedatarios.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name="tipo_documentos")

public class TipoDocumento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idtipo_documento;

	@Column(name = "descripcion", length = 100)
	private String descripcion;

	@OneToMany(mappedBy = "tipo_documento")
	@JsonManagedReference
	private List<Documentos_Escaneados> documentosEscaneados;

	public Long getIddocumento() {
		return idtipo_documento;
	}

	public void setIddocumento(Long iddocumento) {
		this.idtipo_documento = iddocumento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getIdtipo_documento() {
		return idtipo_documento;
	}

	public void setIdtipo_documento(Long idtipo_documento) {
		this.idtipo_documento = idtipo_documento;
	}

	public List<Documentos_Escaneados> getDocumentosEscaneados() {
		return documentosEscaneados;
	}

	public void setDocumentosEscaneados(List<Documentos_Escaneados> documentosEscaneados) {
		this.documentosEscaneados = documentosEscaneados;
	}
//	public Documentos_Escaneados getDocumento_escaneado() {
//		return doc_escaneados;
//	}

//	public void setDocumento_escaneado(Documentos_Escaneados documento_escaneado) {
//		this.doc_escaneados = documento_escaneado;
//	}

	public TipoDocumento(Long idtipo_documento, String descripcion, List<Documentos_Escaneados> documentosEscaneados) {
		this.idtipo_documento = idtipo_documento;
		this.descripcion = descripcion;
		this.documentosEscaneados = documentosEscaneados;
	}

//	public TipoDocumento(Long iddocumento, String descripcion) {
//		super();
//		this.idtipo_documento = iddocumento;
//		this.descripcion = descripcion;
////		this.doc_escaneados = documento_escaneado;
//	}

	public TipoDocumento() {
		super();
	}
	

}
