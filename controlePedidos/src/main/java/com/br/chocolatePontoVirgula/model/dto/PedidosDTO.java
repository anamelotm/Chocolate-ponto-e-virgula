package com.br.chocolatePontoVirgula.model.dto;

import com.br.chocolatePontoVirgula.model.entity.Cliente;
import com.br.chocolatePontoVirgula.model.entity.Pedido;
import com.br.chocolatePontoVirgula.model.repository.ClienteRepository;
import java.util.List;
import java.util.stream.Collectors;

public class PedidosDTO {
    private Long codigo;
    private String nomeCliente;
    private String enderecoEntrega;
    private boolean aberto;
    private ClienteRepository clienteRepository;
    Cliente cliente;
    public PedidosDTO(Pedido pedido) {
        cliente=clienteRepository.getById(pedido.getCodigoCliente());
        this.codigo = pedido.getCodigo();
        this.nomeCliente=cliente.getNome();
        this.enderecoEntrega=pedido.getEnderecoEntrega();
        this.aberto= pedido.isAberto();
    }
    public static List<PedidosDTO> converter(List<Pedido> pedidos){
        return pedidos.stream().map(PedidosDTO::new).collect(Collectors.toList());
    }
}
