package com.br.chocolatePontoVirgula.model.dto;

import com.br.chocolatePontoVirgula.model.entity.Cliente;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ClientePedidoDTO {

    private Long id;
    private String nome;

    public ClientePedidoDTO(Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
    }

    public static List<ClienteDTO> converter(List<Cliente> clientes){
        return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }
}
