package com.br.chocolatePontoVirgula.model.dto;

import com.br.chocolatePontoVirgula.model.entity.Cliente;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ClienteDTO {
    private Long id;
    private String tipo;
    private String documento;
    private String nome;

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.tipo = cliente.getTipo();
        this.documento = cliente.getDocumento();
        this.nome = cliente.getNome();
    }

    public static List<ClienteDTO> converter(Page<Cliente> clientes){
        return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }
}