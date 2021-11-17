package com.br.chocolatePontoVirgula.controller;

import com.br.chocolatePontoVirgula.model.dto.PedidosDTO;
import com.br.chocolatePontoVirgula.model.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.br.chocolatePontoVirgula.model.entity.Pedido;

import java.util.List;
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;


    private PedidosDTO pedidosDTO;
    @PostMapping
    public void save(@RequestBody Pedido pedido){
        pedidoService.save(pedido);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Pedido pedido){
        pedidoService.update(id, pedido);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        pedidoService.excluir(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id) {
        return pedidoService.findById(id);
    }

   @GetMapping
    public List<PedidosDTO> listarTudo() {
        List<PedidosDTO> pedidosLista = pedidoService.consultaGeralPedidos();

        return PedidosDTO.converter(pedidosLista);
    }
    @GetMapping("cliente/{idCliente}")
    public List<Pedido> consultaPedidoCliente(@PathVariable Long idCliente){
        return pedidoService.consultaPedidosCliente(idCliente);

    }
    @GetMapping("/all")
    public ResponseEntity<Page<Pedido>> findAll(Pageable pageable) {
        return pedidoService.findAll(pageable);
    }
}