package com.br.model.entity;

import java.util.Objects;

public class Cliente {
	
	private Long codigo;
	private String tipo;
	private String documento;
	private String nome;
	
	public Cliente() {
		
	}

	public Cliente(Long codigo, String tipo, String documento) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.documento = documento;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	

}
