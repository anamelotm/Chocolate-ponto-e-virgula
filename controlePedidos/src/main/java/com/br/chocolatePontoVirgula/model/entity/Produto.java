package com.br.chocolatePontoVirgula.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", descricaoProduto='" + descricaoProduto + '\'' +
                ", unidadeMedida='" + unidadeMedida + '\'' +
                ", valorUnitario=" + valorUnitario +
                ", status=" + status +
                ", urlFoto='" + urlFoto + '\'' +
                ", peso=" + peso +
                ", dataFabricacao=" + dataFabricacao +
                ", dataValidade=" + dataValidade +
                '}';
    }
}
