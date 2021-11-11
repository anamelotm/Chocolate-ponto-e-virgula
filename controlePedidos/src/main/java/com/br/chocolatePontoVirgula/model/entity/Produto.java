package com.br.chocolatePontoVirgula.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

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

<<<<<<< HEAD
=======

>>>>>>> fedc5758bb3116a2f8b7757d1be52c6598c950de
}
