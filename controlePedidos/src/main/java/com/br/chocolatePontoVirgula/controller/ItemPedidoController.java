package com.br.chocolatePontoVirgula.controller;


import com.br.chocolatePontoVirgula.model.dto.ItemPedidoDTO;
import com.br.chocolatePontoVirgula.model.entity.ItemPedido;
import com.br.chocolatePontoVirgula.model.form.ItemPedidoForm;
import com.br.chocolatePontoVirgula.model.services.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens-pedidos")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @PostMapping
    public void save(@Validated @RequestBody ItemPedidoForm itemPedido){itemPedidoService.save(itemPedido);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody ItemPedido itemPedido){
        itemPedidoService.update(id, itemPedido);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        itemPedidoService.delete(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedido> findById(@PathVariable Long id) {
        return itemPedidoService.findById(id);
    }

    @GetMapping()
    public ResponseEntity<Page<ItemPedido>> findAll(Pageable pageable) {
        return itemPedidoService.findAll(pageable);
    }

    @GetMapping("tela-itens/{id}")
    public List<ItemPedidoDTO> itensDoPedido(@PathVariable Long id){
        return ItemPedidoDTO.converter(itemPedidoService.itensDoPedido(id));
    }
}
