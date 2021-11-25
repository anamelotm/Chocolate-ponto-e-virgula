package com.br.chocolatePontoVirgula.model.form;

import com.br.chocolatePontoVirgula.model.entity.Cliente;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.sql.Date;

@Setter
@Getter
public class PedidoForm {
    private Long id;
    private Cliente cliente;
    private String enderecoEntrega;
    private Date dataPedido;
    private boolean aberto;
    @DecimalMin(value = "0.01",message = "O valor mínimo é R$1.00")
    @DecimalMax(value = "999999.99",message = "Ultrapassou o valor Máximo permitido")
    private double valorTotal;
    @Min(value = 1,message = "A quantidade total precisa ser pelo menos de 1 produto")
    @Max(value = 999999,message = "Ultrapassou a quantidade máxima")
    private int quantidadeTotal;
    private int percentualDesconto;
}
