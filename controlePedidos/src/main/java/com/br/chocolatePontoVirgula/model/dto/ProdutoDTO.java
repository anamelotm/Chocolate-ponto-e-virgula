package com.br.chocolatePontoVirgula.model.dto;

import com.br.chocolatePontoVirgula.model.entity.Produto;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ProdutoDTO {

    private Long id;
    private String nome;
    private String descricaoProduto;
    private String unidadeMedida;
    private double valorUnitario;
    private boolean status;
    private String urlFoto;
    private double peso;
    private Date dataFabricacao;
    private Date dataValidade;

    private Integer quantidadeEstoque;



    public ProdutoDTO(Produto produto){
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricaoProduto = produto.getDescricaoProduto();
        this.unidadeMedida = produto.getUnidadeMedida();
        this.valorUnitario = produto.getValorUnitario();
        this.status = produto.isStatus();
        this.urlFoto = produto.getUrlFoto();
        this.peso = produto.getPeso();
        this.dataFabricacao = produto.getDataFabricacao();
        this.dataValidade = produto.getDataValidade();
        this.quantidadeEstoque = produto.getQuantidadeEstoque();
    }

    public static List<ProdutoDTO> converter(Page<Produto> produtos){
        return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }
}
