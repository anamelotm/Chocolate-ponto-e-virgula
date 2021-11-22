package com.br.chocolatePontoVirgula.model.form;

import com.br.chocolatePontoVirgula.model.entity.Cliente;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Getter
public class PedidoForm {
    private Cliente cliente;
    private String enderecoEntrega;
    private Date dataPedido;
    private boolean aberto;
    @NotBlank(message = "O valor Total é obrigatório")
    private double valorTotal;
    @NotBlank(message = "A quantidade total é obrigatória")
    private int quantidadeTotal;
    private int percentualDesconto;
}
