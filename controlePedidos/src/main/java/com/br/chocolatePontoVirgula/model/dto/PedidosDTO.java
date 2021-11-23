package com.br.chocolatePontoVirgula.model.dto;


import com.br.chocolatePontoVirgula.model.entity.Pedido;
import lombok.Getter;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PedidosDTO {
    private Long id;
    private String dataPedido;
    private String cliente;
    private String situacao;
    private String valorFinal;

    public PedidosDTO(Pedido pedido) {
        this.id = pedido.getId();
        boolean clienteExiste=pedido.getCliente()==null;
        if(!clienteExiste){
            cliente=pedido.getCliente().getNome();
        }
        this.situacao = pedido.isAberto()?"Aberto":"Fechado";
        if(pedido.getPercentualDesconto()==0){
            this.valorFinal = ""+pedido.getValorTotal();
        }
        else {
            this.valorFinal = pedido.retornarValorComDesconto();
        }
    }

    public static List<PedidosDTO> converter(Page<Pedido> pedidos) {
        return pedidos.stream().map(PedidosDTO::new).collect(Collectors.toList());
    }
}
