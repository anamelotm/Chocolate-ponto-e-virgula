package com.br.chocolatePontoVirgula.model.services;


import com.br.chocolatePontoVirgula.model.dto.ItemPedidoDTO;
import com.br.chocolatePontoVirgula.model.entity.ItemPedido;

import com.br.chocolatePontoVirgula.model.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;


    public void save(ItemPedido itemPedido){
        itemPedidoRepository.save(itemPedido);
    }


  public void update( Long id, ItemPedido itemPedido){
       ItemPedido itemPedidoPesquisado = itemPedidoRepository.getById(id);

       if(itemPedidoPesquisado != null){
            itemPedidoPesquisado.setQuantidade(itemPedido.getQuantidade());
            itemPedidoRepository.save(itemPedidoPesquisado);
       }
   }


    public void delete(Long id){
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

    public  List<ItemPedido> itensDoPedido(Long idPedido){
        List<ItemPedido> itemPedido = itemPedidoRepository.itensDoPedido(idPedido);
        return itemPedido;
    }
}
