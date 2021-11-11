package com.br.chocolatePontoVirgula.model.services;

import com.br.chocolatePontoVirgula.model.entity.Pedido;
import com.br.chocolatePontoVirgula.model.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


@Service
public class PedidoService {
    @Autowired
    PedidoRepository pedidoRepository;
    public Pedido save(@Validated Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
}
