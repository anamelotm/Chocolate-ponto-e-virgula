package com.br.chocolatePontoVirgula.model.form;

import com.br.chocolatePontoVirgula.model.entity.Produto;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class ItemPedidoForm {


    private Long idPedido;


    private Produto produto;


    private int quantidade;

  
    private double valorTotal;

}
