package com.br.controlePedidos.model.entity;

import com.br.chocolatePontoVirgula.model.entity.Pedido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {
    Pedido pedido=new Pedido();
    @Test
    void aplicarDesconto() {
        pedido.setValorTotal(100);
        pedido.setPercentualDesconto(0);
        System.out.println(pedido.retornarValorComDesconto());
        assertEquals(100.0,pedido.retornarValorComDesconto());

    }
}