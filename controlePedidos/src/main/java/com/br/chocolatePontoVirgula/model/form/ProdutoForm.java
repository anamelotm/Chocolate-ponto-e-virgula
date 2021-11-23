package com.br.chocolatePontoVirgula.model.form;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Date;

public class ProdutoForm {

    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3)
    private String nome;

    @NotBlank(message = "Descrição do produto é obrigatório")
    private String descricaoProduto;

    @NotBlank(message = "Unidade de medida é obrigatória")
    private String unidadeMedida;

    @NotBlank(message = "Valor unitário é obrigatório")
    private double valorUnitario;

    @NotBlank(message = "Status é obrigatório")
    private boolean status;

    private String urlFoto;

    @NotBlank(message = "Peso é obrigatório")
    private double peso;

    @NotBlank(message = "Data de fabricação é obrigatório")
    private Date dataFabricacao;

    @NotBlank(message = "Data de validade é obrigatório")
    private Date dataValidade;

    @NotBlank(message = "Quantidade do estoque é obrigatório")
    private Integer quantidadeEstoque;
}
