package com.br.chocolatePontoVirgula.controller;

import com.br.chocolatePontoVirgula.model.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.chocolatePontoVirgula.model.entity.Pedido;

@RestController
@RequestMapping(path="/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping(path="/lista-pedidos")
    public ResponseEntity<Page<Pedido>> findAll(PageRequest pageRequest) {
        PageRequest.ofSize(10);

        Page<Pedido> result = pedidoRepository.findAll(pageRequest);
        return ResponseEntity.ok(result);
    }

}