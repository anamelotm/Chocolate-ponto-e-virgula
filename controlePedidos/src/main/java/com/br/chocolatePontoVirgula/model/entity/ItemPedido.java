package com.br.chocolatePontoVirgula.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemPedido {
	@Id
	private Long codigo;
	private int quantidade;
	private Double valorTotal;
	private int codigoPedido;
	private int codigoProduto;
	
	public ItemPedido() {
		
	}

	public ItemPedido(Long codigo, int quantidade, Double valorTotal, int codigoPedido, int codigoProduto) {
		super();
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.valorTotal = valorTotal;
		this.codigoPedido = codigoPedido;
		this.codigoProduto = codigoProduto;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(int codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public int getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	
	

}
