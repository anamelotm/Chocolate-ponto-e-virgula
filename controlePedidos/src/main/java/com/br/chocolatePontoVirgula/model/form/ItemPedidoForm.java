package com.br.chocolatePontoVirgula.model.form;

import com.br.chocolatePontoVirgula.model.entity.Produto;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class ItemPedidoForm {

    @NotBlank(message = "Deve estar associado a um pedido")
    private Long idPedido;

    @NotBlank(message = "Deve conter um produto")
    private Produto produto;

    @NotBlank(message = "Deve informar a quantidade")
    private int quantidade;

    @NotBlank(message = "Deve possuir um valor total")
    private double valorTotal;

}
