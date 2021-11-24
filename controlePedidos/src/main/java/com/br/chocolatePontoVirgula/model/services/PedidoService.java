package com.br.chocolatePontoVirgula.model.services;

import com.br.chocolatePontoVirgula.model.dto.PedidosDTO;
import com.br.chocolatePontoVirgula.model.entity.Cliente;
import com.br.chocolatePontoVirgula.model.entity.Pedido;
import com.br.chocolatePontoVirgula.model.entity.Produto;
import com.br.chocolatePontoVirgula.model.form.PedidoForm;
import com.br.chocolatePontoVirgula.model.repository.PedidoRepository;
import com.br.chocolatePontoVirgula.model.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public ResponseEntity<String> salvar(@Validated PedidoForm pedidoForm) {
        Pedido pedido=new Pedido();
        pedido.setDataPedido(pedido.getDataAtual());
        pedido.setCliente(null);
        pedido.setAberto(true);
        pedido.setPercentualDesconto(0);
        pedido.setEnderecoEntrega(null);
        pedido.setValorTotal(pedidoForm.getValorTotal());
        pedido.setQuantidadeTotal(pedidoForm.getQuantidadeTotal());
        return ResponseEntity.ok().body(pedidoRepository.save(pedido).getId()+"");
    }

    public void update(Long id, Pedido pedido) throws URISyntaxException {
        Optional<Pedido> pedidoPesquisado = Optional.of(pedidoRepository.getById(id));
        pedidoPesquisado.get().setCliente(pedido.getCliente());
        pedidoPesquisado.get().setEnderecoEntrega(pedido.getEnderecoEntrega());
        List<Pedido> pedidos=pedidoRepository.consultaPedidosCliente(pedido.getCliente().getId());
        if((pedidos.isEmpty()) && (pedidoPesquisado.get().isAberto())){
            pedidoPesquisado.get().setPercentualDesconto(10);
        }
        pedidoRepository.save(pedidoPesquisado.get());
    }



    public Pedido findById(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Não foi encontrado um pedido com esse id"+id));
        return pedido;
    }

    @Query(value = "SELECT * FROM pedido p WHERE p.id_cliente = ?")

    public List<Pedido> consultaPedidosCliente(Long idCliente) {
        return pedidoRepository.consultaPedidosCliente(idCliente);

    }

    public Page<Pedido> findAll(Pageable pageable) {
        return pedidoRepository.findAll(pageable);
    }

    public List<PedidosDTO> consultaGeralPedidos() {
        return null;
    }

    public void fecharPedido(Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        pedido.get().setAberto(false);
        pedidoRepository.save(pedido.get());
    }
}
