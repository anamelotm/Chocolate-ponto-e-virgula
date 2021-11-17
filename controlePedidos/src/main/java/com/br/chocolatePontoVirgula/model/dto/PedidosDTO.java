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
    private String nome;
    private String enderecoEntrega;
    private boolean aberto;
    private double valorTotal;


    public PedidosDTO(Long id, String nome, String enderecoEntrega, boolean aberto, double valorTotal) {
        this.id = id;
        this.nome=nome;
        this.enderecoEntrega = enderecoEntrega;
        this.aberto = aberto;
        this.valorTotal=valorTotal;
    }

    public static List<PedidosDTO> converter(List<PedidosDTO> pedidos) {
        return pedidos;
    }
}
