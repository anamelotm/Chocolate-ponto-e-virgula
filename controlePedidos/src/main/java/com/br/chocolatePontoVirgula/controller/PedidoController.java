package com.br.chocolatePontoVirgula.controller;

import com.br.chocolatePontoVirgula.model.dto.PedidoDTO;
import com.br.chocolatePontoVirgula.model.dto.PedidoFormDTO;
import com.br.chocolatePontoVirgula.model.dto.PedidosDTO;
import com.br.chocolatePontoVirgula.model.entity.Cliente;
import com.br.chocolatePontoVirgula.model.form.PedidoForm;
import com.br.chocolatePontoVirgula.model.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    public ResponseEntity<PedidoDTO> save(@Validated @RequestBody PedidoForm pedidoForm, BindingResult result) {
        System.out.println(result.hasErrors());
        if (result.hasErrors()) {
            List<PedidoForm> pedidoForms = new ArrayList<>();
            pedidoForms.add(pedidoForm);
            ResponseEntity.badRequest().body(new PedidoFormDTO((PedidoForm) pedidoForms));
        } else {
            Pedido pedidoSalvo = pedidoService.save(pedidoForm);
            return ResponseEntity.ok().body(new PedidoDTO(pedidoSalvo));
        }
        return null;
    }

    @PatchMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody Pedido pedido) throws URISyntaxException {
        pedidoService.update(id, pedido);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        pedidoService.excluir(id);
    }

    @GetMapping("/{id}")
    public List<PedidoDTO> findById(@PathVariable Long id) {
        List<Pedido> pedido = new ArrayList<>();
        pedido.add(pedidoService.findById(id));
        return PedidoDTO.converter(pedido);
    }


    @GetMapping("pageable")
    public List<PedidosDTO> listarTudo(Pageable pageable) {

        Page<Pedido> pedidosLista = pedidoService.findAll(pageable);
        System.out.println(pedidosLista.getTotalPages());
        return PedidosDTO.converter(pedidosLista);

    }
    @GetMapping("totaldepaginas")
    public int retornaTotalpaginas(){
        Pageable pageable=PageRequest.of(0,10);
        Page<Pedido> pedidosLista = pedidoService.findAll(pageable);
        return pedidosLista.getTotalPages();
    }
    @GetMapping("cliente/{idCliente}")
    public List<Pedido> consultaPedidoCliente(@PathVariable Long idCliente) {
        return pedidoService.consultaPedidosCliente(idCliente);
    }

    @PatchMapping("fecharpedido/{id}")
    public void fecharPedido(@PathVariable Long id) {
        pedidoService.fecharPedido(id);
    }
}