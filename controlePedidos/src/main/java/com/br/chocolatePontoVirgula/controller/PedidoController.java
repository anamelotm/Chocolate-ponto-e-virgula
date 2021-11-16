package com.br.chocolatePontoVirgula.controller;

import com.br.chocolatePontoVirgula.model.dto.PedidosDTO;
import com.br.chocolatePontoVirgula.model.entity.Cliente;
import com.br.chocolatePontoVirgula.model.repository.PedidoRepository;
import com.br.chocolatePontoVirgula.model.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.br.chocolatePontoVirgula.model.entity.Pedido;

import java.sql.Date;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;


    private PedidosDTO pedidosDTO;
    @Autowired
    PedidoRepository pedidoRepository;
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
        List<Pedido> pedidosLista = pedidoRepository.findAll();

        return PedidosDTO.converter(pedidosLista);
    }
    @GetMapping("/all")
    public ResponseEntity<Page<Pedido>> findAll(Pageable pageable) {
        return pedidoService.findAll(pageable);
    }
}