package com.br.chocolatePontoVirgula.model.form;

import com.br.chocolatePontoVirgula.model.entity.Produto;
import lombok.Getter;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Getter
public class ItemPedidoForm {

    @Min(1)
    @Max(999999)
    private Long idPedido;


    private Produto produto;

    @Min(1)
    @Max(999999)
    private int quantidade;

    @DecimalMin("0.01")
    @DecimalMax("999999.99")
    private double valorTotal;

}
