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
    @PastOrPresent(message = "datainválida")
    private Date dataPedido;
    private boolean aberto;
    @DecimalMin("0.01")
    @DecimalMax("999999.99")
    private double valorTotal;
    @Min(1)
    @Max(999999)
    private int quantidadeTotal;
    private int percentualDesconto;
}
