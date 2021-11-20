package com.br.chocolatePontoVirgula.model.services;

import com.br.chocolatePontoVirgula.model.dto.PedidosDTO;
import com.br.chocolatePontoVirgula.model.entity.Cliente;
import com.br.chocolatePontoVirgula.model.entity.Pedido;
import com.br.chocolatePontoVirgula.model.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public void update(Long id, Pedido pedido) {
        Optional<Pedido> pedidoPesquisado = Optional.of(pedidoRepository.getById(id));
        pedidoPesquisado.get().setCliente(pedido.getCliente());
        pedidoPesquisado.get().setEnderecoEntrega(pedido.getEnderecoEntrega());
        pedidoRepository.save(pedidoPesquisado.get());
    }


    public void excluir(Long id) {
        pedidoRepository.deleteById(id);
    }


    public Pedido findById(Long id) {
        Pedido pedido = pedidoRepository.findById(id).get();
        return pedido;
    }

    @Query(value = "SELECT * FROM pedido p WHERE p.id_cliente = ?")

    public List<Pedido> consultaPedidosCliente(Long idCliente) {
        return pedidoRepository.consultaPedidosCliente(idCliente);

    }

    public ResponseEntity<Page<Pedido>> findAll(Pageable pageable) {

        int size = 10;
        PageRequest pageRequest = PageRequest.ofSize(size);

        Page<Pedido> result = pedidoRepository.findAll(pageRequest);
        return ResponseEntity.ok(result);
    }

    public List<PedidosDTO> consultaGeralPedidos() {
        return null;
    }
}
