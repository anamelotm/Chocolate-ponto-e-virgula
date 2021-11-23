package com.br.chocolatePontoVirgula.model.form;

import com.br.chocolatePontoVirgula.model.entity.Cliente;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.sql.Date;

@Setter
@Getter
public class PedidoForm {
    private Cliente cliente;
    private String enderecoEntrega;
    private Date dataPedido;
    private boolean aberto;
    @NotNull
    @Digits(message = "O valor Total é obrigatório", integer = 6, fraction = 2)
    private double valorTotal;
    @NotNull
    @Digits(message = "A quantidade total é obrigatória",integer = 4,fraction = 0)
    private int quantidadeTotal;
    private int percentualDesconto;
}
