package com.br.chocolatePontoVirgula.model.dto;


import com.br.chocolatePontoVirgula.model.entity.ItemPedido;

import java.util.List;
import java.util.stream.Collectors;

public class ItemPedidoDTO {

    private Long id;
    private String nomeProduto;
    private Double valorUnitario;
    private int quantidade;
    private Double valorTotal;
    private Long codigoPedido;


    public ItemPedidoDTO(ItemPedido itemPedido) {
        this.id = itemPedido.getId();
        this.nomeProduto = itemPedido.getProduto().getNome();
        this.valorUnitario = itemPedido.getProduto().getValorUnitario();
        this.quantidade = itemPedido.getQuantidade();
        this.valorTotal = itemPedido.getValorTotal();
        this.codigoPedido = itemPedido.getPedido().getId();

    }

   public static List<ItemPedidoDTO> converter(List<ItemPedido> itensPedidos){
      return itensPedidos.stream().map(ItemPedidoDTO::new).collect(Collectors.toList());
   }
}
