package com.br.chocolatePontoVirgula.model.services;

import com.br.chocolatePontoVirgula.model.entity.Pedido;
import com.br.chocolatePontoVirgula.model.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


@Service
public class PedidoService {
    @Autowired
    PedidoRepository pedidoRepository;

    public Pedido save(@Validated Pedido pedido) {
        return pedidoRepository.save(pedido);
    }




    public void update( Long id, Pedido pedido){
        Pedido pedidoPesquisado = pedidoRepository.getById(id);

        if(pedidoPesquisado != null){
            pedidoPesquisado.setAberto(pedido.isAberto());
            pedidoRepository.save(pedidoPesquisado);
        }
    }


    public void excluir(Long id){
        pedidoRepository.deleteById(id);
    }


    public ResponseEntity<Pedido> findById(Long id) {
        Pedido pedido = pedidoRepository.findById(id).get();
        return ResponseEntity.ok().body(pedido);
    }


    public ResponseEntity<Page<Pedido>> findAll(Pageable pageable) {

        int size = 10;
        PageRequest pageRequest = PageRequest.ofSize(size);

        Page<Pedido> result = pedidoRepository.findAll(pageRequest);
        return ResponseEntity.ok(result);
    }
}
