package com.br.chocolatePontoVirgula.model.dto;

import com.br.chocolatePontoVirgula.model.entity.Cliente;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ClienteDTO {

    private String tipo;
    private String documento;
    private String nome;

    public ClienteDTO(Cliente cliente) {
        this.tipo = cliente.getTipo();
        this.documento = cliente.getDocumento();
        this.nome = cliente.getNome();
    }

    public static List<ClienteDTO> converter(List<Cliente> clientes){
        return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }
}
