package com.br.chocolatePontoVirgula.model.dto;

import com.br.chocolatePontoVirgula.model.entity.Produto;
import lombok.Getter;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ProdutoDTO {

    //codigo, nome, valor_unitario, data_validade, quantidade_estoque
    private Long codigo;

    private String nome;
    private String descricaoProduto;
    private String unidadeMedida;
    private double valorUnitario;
    private boolean status;
    private String urlFoto;
    private double peso;
    private Date dataFabricacao;
    private Date dataValidade;

    public ProdutoDTO(Produto produto){
        this.nome = produto.getNome();
        this.descricaoProduto = produto.getDescricaoProduto();
        this.unidadeMedida = produto.getUnidadeMedida();
        this.valorUnitario = produto.getValorUnitario();
        this.status = produto.isStatus();
        this.urlFoto = produto.getUrlFoto();
        this.peso = produto.getPeso();
        this.dataFabricacao = produto.getDataFabricacao();
        this.dataValidade = produto.getDataValidade();
    }

    public static List<ProdutoDTO> converter(List<Produto> produtos){
        return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }
}
