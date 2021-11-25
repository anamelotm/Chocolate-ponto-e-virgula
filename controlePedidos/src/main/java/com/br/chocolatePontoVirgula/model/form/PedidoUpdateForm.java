package com.br.chocolatePontoVirgula.model.form;

import com.br.chocolatePontoVirgula.model.entity.Cliente;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Setter
@Getter
public class PedidoUpdateForm {
    private Long id;
    @NotNull(message = "informe o cliente")
    private Cliente cliente;
    @NotBlank(message = "informe o endereço")
    private String enderecoEntrega;
}
