package com.br.chocolatePontoVirgula.controller;

import com.br.chocolatePontoVirgula.model.dto.PedidoDTO;
import com.br.chocolatePontoVirgula.model.dto.PedidosDTO;
import com.br.chocolatePontoVirgula.model.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.br.chocolatePontoVirgula.model.entity.Pedido;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;


    private PedidosDTO pedidosDTO;
    @PostMapping
    public ResponseEntity<PedidoDTO> save(@RequestBody Pedido pedido) throws URISyntaxException {
        pedido.setDataPedido(pedido.getDataAtual());
        pedido.setPercentualDesconto(0);
        pedido.setAberto(true);
        pedidoService.save(pedido);
        URI uri = new URI("http://localhost:8080/pedidos/"+pedido.getId());
        return ResponseEntity.created(uri).body(new PedidoDTO(pedido));
    }

    @PatchMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody Pedido pedido) throws URISyntaxException {
       pedidoService.update(id, pedido);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        pedidoService.excluir(id);
    }

    @GetMapping("/{id}")
    public List<PedidoDTO> findById(@PathVariable Long id) {
        List<Pedido> pedido=new ArrayList<>();
        pedido.add(pedidoService.findById(id));
        return PedidoDTO.converter(pedido);
    }


   @GetMapping("pageable")

   @GetMapping
    public List<PedidosDTO> listarTudo(Pageable pageable) {

       Page<Pedido> pedidosLista = pedidoService.findAll(pageable);
       System.out.println(pedidosLista.getTotalPages());
       return PedidosDTO.converter(pedidosLista);

    }
    @GetMapping("cliente/{idCliente}")
    public List<Pedido> consultaPedidoCliente(@PathVariable Long idCliente){
        return pedidoService.consultaPedidosCliente(idCliente);


    @GetMapping
    public List<Pedido> listarTudo() {
        //List<PedidosDTO> pedidosLista = pedidoRepository.consultaGeralPedidos();
        return pedidoRepository.findAll();

        //return PedidosDTO.converter(pedidosLista);
    }
    
    @PatchMapping("fecharpedido/{id}")
    public void fecharPedido(@PathVariable Long id){
        pedidoService.fecharPedido(id);
    }
}