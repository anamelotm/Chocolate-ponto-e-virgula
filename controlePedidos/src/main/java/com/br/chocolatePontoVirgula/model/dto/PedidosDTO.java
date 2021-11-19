package com.br.chocolatePontoVirgula.model.dto;


import com.br.chocolatePontoVirgula.model.entity.Cliente;
import com.br.chocolatePontoVirgula.model.entity.Pedido;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PedidosDTO {
    private Long id;
    private String nome;
    private String enderecoEntrega;
    private boolean aberto;
    private double valorSemDesconto;
    private double valorTotal;

    public PedidosDTO(Pedido pedido) {
        this.id = pedido.getId();
        Class<Pedido> pedidoClass= (Class<Pedido>) pedido.getClass();
        for(Field field:pedidoClass.getFields()){
            if(field.getName().equals("cliente")){
                String nome=pedido.getCliente().getNome();
            }

        }
        this.enderecoEntrega = pedido.getEnderecoEntrega();
        this.aberto = pedido.isAberto();
        this.valorSemDesconto = pedido.getValorTotal();
    }

    public static List<PedidosDTO> converter(ResponseEntity<Page<Pedido>> pedidos) {
        return pedidos.getBody().stream().map(PedidosDTO::new).collect(Collectors.toList());
    }
}
