package com.br.chocolatePontoVirgula.model.dto;

import com.br.chocolatePontoVirgula.model.entity.Pedido;
import com.br.chocolatePontoVirgula.model.form.PedidoForm;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
@Getter
public class PedidoFormDTO {

    private Long id;
    private String nome;
    private String enderecoEntrega;
    private String dataPedido;
    private String aberto;
    private double valorTotal;
    private double valorComDesconto;
    private int quantidadeTotal;
    private int percentualDesconto;

    public PedidoFormDTO(PedidoForm pedido) {

        boolean clienteExiste=pedido.getCliente()==null;
        if(!clienteExiste){
            nome=pedido.getCliente().getNome();
        }
        this.enderecoEntrega = pedido.getEnderecoEntrega();
        SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
        this.dataPedido=formato.format(pedido.getDataPedido());
        this.aberto = pedido.isAberto()?"Sim":"Não";
        this.valorTotal = pedido.getValorTotal();

        this.quantidadeTotal=pedido.getQuantidadeTotal();
        this.percentualDesconto=pedido.getPercentualDesconto();
    }

    public static List<PedidoFormDTO> converter(List<PedidoForm> pedido) {
        return pedido.stream().map(PedidoFormDTO::new).collect(Collectors.toList());
    }
}
