package com.br.chocolatePontoVirgula.model.services;


import com.br.chocolatePontoVirgula.model.entity.ItemPedido;

import com.br.chocolatePontoVirgula.model.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;


    public void save(ItemPedido itemPedido){
        itemPedidoRepository.save(itemPedido);
    }


//    public void update( Long id, Cliente cliente){
//        ItemPedido itemPedidoPesquisado = itemPedidoRepository.getById(id);
//
//        if(itemPedidoPesquisado != null){
//            itemPedidoPesquisado.;
//            clienteRepository.save(clientePesquisado);
//        }
//    } REVISAR ESSE MÉTODO


    public void excluir(Long id){
        itemPedidoRepository.deleteById(id);
    }


    public ResponseEntity<ItemPedido> findById(Long id) {
        ItemPedido itemPedido = itemPedidoRepository.findById(id).get();
        return ResponseEntity.ok().body(itemPedido);
    }


    public ResponseEntity<Page<ItemPedido>> findAll(Pageable pageable) {

        int size = 10;
        PageRequest pageRequest = PageRequest.ofSize(size);

        Page<ItemPedido> result = itemPedidoRepository.findAll(pageRequest);
        return ResponseEntity.ok(result);
    }
}
