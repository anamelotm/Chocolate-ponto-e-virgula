package com.br.chocolatePontoVirgula.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	private int codigo;
	private String tipo;
	private String documento;
	private String nome;
	
	public Cliente() {
		
	}

	public Cliente(int codigo, String tipo, String documento, String nome) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.documento = documento;
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
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
