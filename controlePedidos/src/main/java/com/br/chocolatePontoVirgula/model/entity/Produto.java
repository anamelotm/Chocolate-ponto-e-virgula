package com.br.chocolatePontoVirgula.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricaoProduto;
    @Column(name = "unidade_medida")
    private String unidadeMedida;
    @Column(name = "valor_unitario")
    private double valorUnitario;
    @Column(name = "status")
    private boolean status;
    @Column(name = "url_Fotos")
    private String urlFoto;
    @Column(name = "peso")
    private double peso;
    @Column(name = "data_fabricacao")
    private Date dataFabricacao;
    @Column(name = "data_validade")
    private Date dataValidade;
    @Column(name = "quantidade_estoque")
    private Integer quantidadeEstoque;


    public String Status() {
        if (status) {
            return "Ativo";
        } else {
            return "Inativo";
        }
    }


    public void setStatus(boolean status) {
        this.status = status;
    }

}
