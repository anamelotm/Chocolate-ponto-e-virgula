package com.br.chocolatePontoVirgula.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(name = "data_pedido",nullable = false)
    protected Date dataPedido;
    @Column(name = "endereco_entrega")
    protected String enderecoEntrega;
    @Column(name = "aberto",nullable = false)
    protected boolean aberto;
    @Column(name = "valor_sem_desconto",nullable = false)
    protected double valorSemDescontro;
    @Column(name = "valor_com_desconto")
    protected double valorComDescontro;
    @Column(name = "quantidade_total",nullable = false)
    protected int quantidadeTotal;
    @Column(name = "percentual_desconto")
    protected int percentualDesconto;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public boolean fechado() {
        return this.aberto;
    }

    public void aplicarDesconto() {
        if (!fechado()) {
            valorComDescontro *= (1 - (this.percentualDesconto * 100));
        } else {
            System.out.println("Não foi possível aplicar o desconto");
        }
    }
}