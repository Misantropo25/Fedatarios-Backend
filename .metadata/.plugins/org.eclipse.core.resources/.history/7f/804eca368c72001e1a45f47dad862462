package com.fedatarios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tipo_documentos")

public class TipoDocumento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idtipo_documento;
	
	private String descripcion;
	
	@OneToOne(mappedBy = "tipo_documento")
	private Documentos_Escaneados doc_escaneados;

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

	public Documentos_Escaneados getDocumento_escaneado() {
		return doc_escaneados;
	}

	public void setDocumento_escaneado(Documentos_Escaneados documento_escaneado) {
		this.doc_escaneados = documento_escaneado;
	}

	public TipoDocumento(Long iddocumento, String descripcion, Documentos_Escaneados documento_escaneado) {
		super();
		this.idtipo_documento = iddocumento;
		this.descripcion = descripcion;
		this.doc_escaneados = documento_escaneado;
	}

	public TipoDocumento() {
		super();
	}
	

}
