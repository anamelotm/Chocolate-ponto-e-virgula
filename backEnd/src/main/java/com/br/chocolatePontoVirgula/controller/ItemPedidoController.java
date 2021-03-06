package com.br.chocolatePontoVirgula.controller;


import com.br.chocolatePontoVirgula.model.dto.ItemPedidoDTO;
import com.br.chocolatePontoVirgula.model.entity.ItemPedido;
import com.br.chocolatePontoVirgula.model.form.ItemPedidoForm;
import com.br.chocolatePontoVirgula.model.services.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/itens-pedidos")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @PostMapping
    public void save(@Validated @RequestBody ItemPedidoForm itemPedido) throws URISyntaxException {itemPedidoService.save(itemPedido);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedido> findById(@PathVariable Long id) {
        return itemPedidoService.findById(id);
    }

    @GetMapping("pageable")
    public List<ItemPedidoDTO> findAll(Pageable pageable) {
        Page<ItemPedido> itensPedidos = itemPedidoService.findAll(pageable);
        return ItemPedidoDTO.converter(itensPedidos);
    }

    //retorna o total de paginas
    @GetMapping("totaldepaginas")
    public int retornaTotalPaginas(){
        Pageable pageable= PageRequest.of(0,10);
        Page<ItemPedido> itensPedidos = itemPedidoService.findAll(pageable);
        return itensPedidos.getTotalPages();
    }

    @GetMapping("tela-itens/{id}")
    public List<ItemPedidoDTO> itensDoPedido(@PathVariable Long id){
        return ItemPedidoDTO.converterList(itemPedidoService.itensDoPedido(id));
    }

    @GetMapping("produtosnoitem/{id}")
    public List<ItemPedido> produtoHasPedido(@PathVariable Long id){
        return itemPedidoService.produtoHasPedido(id);
    }
}
