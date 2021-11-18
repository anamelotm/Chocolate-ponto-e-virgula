package com.br.chocolatePontoVirgula.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item_pedido")
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "quantidade")
	private int quantidade;

	@Column(name = "valor_total")
	private Double valorTotal;

	@Column(name = "codigo_pedido")
	private Long codigoPedido;

	@Column(name = "codigo_produto")
	private Long codigoProduto;

}
