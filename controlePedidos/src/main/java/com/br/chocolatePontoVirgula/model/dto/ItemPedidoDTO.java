package com.br.chocolatePontoVirgula.model.dto;


import com.br.chocolatePontoVirgula.model.entity.ItemPedido;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ItemPedidoDTO {

    private Long id;
    private String nomeProduto;
    private Double valorUnitario;
    private int quantidade;
    private Double valorTotal;
    private Long idPedido;


    public ItemPedidoDTO(ItemPedido item) {
        this.id = item.getId();
        this.nomeProduto = item.getProduto().getNome();
        this.valorUnitario = item.getProduto().getValorUnitario();
        this.quantidade = item.getQuantidade();
        this.valorTotal = item.getValorTotal();
        this.idPedido = item.getIdPedido();
    }

    public static List<ItemPedidoDTO> converter(List<ItemPedido> itensPedidos){
      return itensPedidos.stream().map(ItemPedidoDTO::new).collect(Collectors.toList());
   }
}
