package com.br.controlePedidos.model.entity;

import com.br.chocolatePontoVirgula.model.entity.Pedido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {
    Pedido pedido=new Pedido();
    @Test
    void aplicarDesconto() {
        pedido.setValorTotal(100);
        pedido.setPercentualDesconto(10);
        assertEquals("90,00",pedido.retornarValorComDesconto());

    }
}