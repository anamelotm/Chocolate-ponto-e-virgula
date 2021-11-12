package com.br.chocolatePontoVirgula.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int codigo;
    protected Date dataPedido;
    protected int codigoCliente;
    protected String enderecoEntrega;
    protected boolean aberto;
    protected double valorTotal;
    protected int quantidadeTotal;
    protected int percentualDesconto;



    public boolean fechado() {
        return this.aberto;
    }

    public void aplicarDesconto() {
        if (!fechado()) {
            valorTotal *= (1 - (this.percentualDesconto * 100));
        } else {
            System.out.println("Não foi possível aplicar o desconto");
        }
    }
}