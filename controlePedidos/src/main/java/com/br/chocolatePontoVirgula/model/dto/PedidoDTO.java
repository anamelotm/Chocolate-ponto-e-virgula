package com.br.chocolatePontoVirgula.model.dto;


import com.br.chocolatePontoVirgula.model.entity.Cliente;
import com.br.chocolatePontoVirgula.model.entity.Pedido;
import com.br.chocolatePontoVirgula.model.form.PedidoForm;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PedidoDTO {
    private Long id;
    private String nome;
    private String enderecoEntrega;
    private String dataPedido;
    private String aberto;
    private double valorTotal;
    private String valorComDesconto;
    private int quantidadeTotal;
    private int percentualDesconto;

    public PedidoDTO(Pedido pedido) {
        this.id = pedido.getId();
        boolean clienteExiste=pedido.getCliente()==null;
        if(!clienteExiste){
            nome=pedido.getCliente().getNome();
        }
        this.enderecoEntrega = pedido.getEnderecoEntrega();
        SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
        this.dataPedido=formato.format(pedido.getDataPedido());
        this.aberto = pedido.isAberto()?"Sim":"Não";
        this.valorTotal = pedido.getValorTotal();
        if(pedido.getPercentualDesconto()!=0){
            this.valorComDesconto=""+pedido.retornarValorComDesconto();
        }
        this.quantidadeTotal=pedido.getQuantidadeTotal();
        this.percentualDesconto=pedido.getPercentualDesconto();
    }

    public static List<PedidoDTO> converter(List<Pedido> pedido) {
        return pedido.stream().map(PedidoDTO::new).collect(Collectors.toList());
    }
}
