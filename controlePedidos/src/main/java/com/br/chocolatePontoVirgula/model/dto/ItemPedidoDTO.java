package com.br.chocolatePontoVirgula.model.dto;


import com.br.chocolatePontoVirgula.model.entity.ItemPedido;

import java.util.List;
import java.util.stream.Collectors;

public class ItemPedidoDTO {

    private Long codigo;
    private int quantidade;
    private Double valorTotal;
    private Long codigoPedido;
    private Long codigoProduto;

    public ItemPedidoDTO(ItemPedido itemPedido) {
        this.codigo = itemPedido.getId();
        this.quantidade = itemPedido.getQuantidade();
        this.valorTotal = itemPedido.getValorTotal();
        this.codigoPedido = itemPedido.getCodigoPedido();
        this.codigoProduto = itemPedido.getCodigoProduto();
    }

   public static List<ItemPedidoDTO> converter(List<ItemPedido> itensPedidos){
      return itensPedidos.stream().map(ItemPedidoDTO::new).collect(Collectors.toList());
   }
}
