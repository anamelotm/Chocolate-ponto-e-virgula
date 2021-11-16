package com.br.chocolatePontoVirgula.model.dto;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.br.chocolatePontoVirgula.model.entity.Cliente;
import com.br.chocolatePontoVirgula.model.entity.Pedido;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PedidosDTO {
    private Long id;
    private String enderecoEntrega;
    private boolean aberto;
    private double valorTotal;


    public PedidosDTO(Pedido pedido) {
        this.id = pedido.getId();
        this.enderecoEntrega = pedido.getEnderecoEntrega();
        this.aberto = pedido.isAberto();
        this.valorTotal=pedido.getValorTotal();
    }

    public static List<PedidosDTO> converter(List<Pedido> pedidos) {
        return pedidos.stream().map(PedidosDTO::new).collect(Collectors.toList());
    }
}
