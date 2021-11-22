package com.br.chocolatePontoVirgula.model.dto;


import com.br.chocolatePontoVirgula.model.entity.Pedido;
import lombok.Getter;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PedidosDTO {
    private Long id;
    private String nome;
    private String enderecoEntrega;
    private boolean aberto;
    private double valorFinaldoPedido;

    public PedidosDTO(Pedido pedido) {
        this.id = pedido.getId();
        boolean clienteExiste=pedido.getCliente()==null;
        if(!clienteExiste){
            nome=pedido.getCliente().getNome();
        }
        this.enderecoEntrega = pedido.getEnderecoEntrega();
        this.aberto = pedido.isAberto();
        if(pedido.getPercentualDesconto()==0){
            this.valorFinaldoPedido = pedido.getValorTotal();
        }
        else {
            this.valorFinaldoPedido = pedido.retornarValorComDesconto();
        }
    }

    public static List<PedidosDTO> converter(Page<Pedido> pedidos) {
        return pedidos.stream().map(PedidosDTO::new).collect(Collectors.toList());
    }
}
