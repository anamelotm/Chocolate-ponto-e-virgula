package com.br.chocolatePontoVirgula.model.form;

import lombok.Getter;
;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class ClienteForm {

    @NotBlank(message = "tipo é obrigatório")
    @Size(min = 6)
    private String tipo;

    @NotBlank(message = "documento é obrigatório")
    private String documento;

   @NotBlank(message = "documento é obrigatório")
    private String nome;
}
