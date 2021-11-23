package com.br.chocolatePontoVirgula.model.form;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.sql.Date;

@Getter
@Setter
public class ProdutoForm {

    @NotNull(message = "Nome é obrigatório")
    @Size(min = 3)
    private String nome;

    private String descricaoProduto;

    @NotNull(message = "Unidade de medida é obrigatória")
    private String unidadeMedida;

    @NotNull(message = "Valor unitário é obrigatório")
    private double valorUnitario;

    @NotNull(message = "Status é obrigatório")
    private boolean status;

    private String urlFoto;

    @NotNull(message = "Peso é obrigatório")
    @DecimalMin("0.01")
    @DecimalMax("999999.99")
    private double peso;

    @NotNull(message = "Data de fabricação é obrigatória")
    private Date dataFabricacao;

    @NotNull(message = "Data de validade é obrigatória")
    private Date dataValidade;

    @NotNull(message = "Quantidade do estoque é obrigatório")
    @Min(value = 1)
    @Max(999999)
    private Integer quantidadeEstoque;
}
