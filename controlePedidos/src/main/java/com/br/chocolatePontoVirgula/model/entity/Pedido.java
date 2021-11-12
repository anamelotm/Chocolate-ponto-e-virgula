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
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int codigo;
    @Column(name = "data_pedido")
    protected Date dataPedido;
    @Column(name = "codigo_cliente")
    protected int codigoCliente;
    @Column(name = "endereco_entrega")
    protected String enderecoEntrega;
    @Column(name = "aberto")
    protected boolean aberto;
    @Column(name = "valor_total")
    protected double valorTotal;
    @Column(name = "quantidade_total")
    protected int quantidadeTotal;
    @Column(name = "percentual_desconto")
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