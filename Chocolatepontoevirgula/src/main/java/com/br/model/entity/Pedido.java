package com.br.model.entity;

import java.sql.Timestamp;

public class Pedido {
    protected int codigo;
    protected Timestamp dataPedido;
    protected int codigoCliente;
    protected String enderecoEntrega;
    protected boolean situacao;
    protected double valorTotal;
    protected int quantidadeTotal;
    protected int percentualDesconto;
    public Pedido(){

    }

    public Pedido(int codigo, Timestamp dataPedido, int codigoCliente, String enderecoEntrega, boolean situacao, double valorTotal, int quantidadeTotal, int percentualDesconto) {
        this.codigo = codigo;
        this.dataPedido = dataPedido;
        this.codigoCliente = codigoCliente;
        this.enderecoEntrega = enderecoEntrega;
        this.situacao = situacao;
        this.valorTotal = valorTotal;
        this.quantidadeTotal = quantidadeTotal;
        this.percentualDesconto = percentualDesconto;
    }

    public int getCodigo() {
        return codigo;
    }

    public Timestamp getDataPedido() {
        return dataPedido;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public int getPercentualDesconto() {
        return percentualDesconto;
    }
    public boolean isFechado(){
        if(this.situacao){
            return false;
        }
        else {
            return true;
        }
    }
    public void aplicarDesconto(){
        if(!isFechado()){
            valorTotal*=(1-(this.percentualDesconto*100));
        }
        else{
            System.out.println("Não foi possível aplicar o desconto");
        }
    }
}
