package com.br.chocolatePontoVirgula.model.form;

import com.br.chocolatePontoVirgula.model.entity.Cliente;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
public class PedidoForm {
    private Cliente cliente;
    private String enderecoEntrega;
    @NotNull(message = "A Data do pedido é obrigatória")
    @NotEmpty(message = "A Data do pedido é obrigatória")
    @Size(min = 10,max = 10)
    private Date dataPedido;
    @NotEmpty
    @NotEmpty
    private boolean aberto;
    @NotEmpty(message = "O valor Total é obrigatório")
    @NotNull(message = "O valor Total é obrigatório")
    private double valorTotal;
    @NotEmpty(message = "A quantidade total é obrigatória")
    @NotNull(message = "O valor Total é obrigatório")
    private int quantidadeTotal;
    @NotEmpty(message = "O valor Total é obrigatório")
    @NotNull(message = "O valor Total é obrigatório")
    private int percentualDesconto;
}
