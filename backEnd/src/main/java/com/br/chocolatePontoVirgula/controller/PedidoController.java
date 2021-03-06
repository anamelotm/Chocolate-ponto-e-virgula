package com.br.chocolatePontoVirgula.controller;

import com.br.chocolatePontoVirgula.model.dto.PedidoDTO;
import com.br.chocolatePontoVirgula.model.dto.PedidosDTO;
import com.br.chocolatePontoVirgula.model.form.PedidoForm;
import com.br.chocolatePontoVirgula.model.form.PedidoUpdateForm;
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

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;


    private PedidosDTO pedidosDTO;

    @PostMapping
    public ResponseEntity<String> salvar(@Validated @RequestBody PedidoForm pedidoForm) {
        Pedido pedido = new Pedido();
        pedidoForm.setDataPedido(pedido.getDataAtual());
        pedidoForm.setAberto(true);
        pedidoForm.setPercentualDesconto(0);
        return pedidoService.salvar(pedidoForm);
    }

    @PatchMapping("{id}")
    public void update(@PathVariable Long id, @Validated @RequestBody PedidoUpdateForm pedidoUpdate) throws URISyntaxException {
        pedidoService.update(id, pedidoUpdate);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        PedidoDTO pedidoDTO = new PedidoDTO(pedidoService.findById(id));
        return ResponseEntity.ok().body(pedidoDTO);
    }


    @GetMapping("pageable")
    public List<PedidosDTO> listarTudo(Pageable pageable) {

        Page<Pedido> pedidosLista = pedidoService.findAll(pageable);
        return PedidosDTO.converter(pedidosLista);

    }

    @GetMapping("totaldepaginas")
    public int retornaTotalpaginas() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Pedido> pedidosLista = pedidoService.findAll(pageable);
        return pedidosLista.getTotalPages();
    }

    @GetMapping("cliente/{idCliente}")
    public List<Pedido> consultaPedidoCliente(@PathVariable Long idCliente) {
        return pedidoService.consultaPedidosCliente(idCliente);
    }

    @PatchMapping("fecharpedido/{id}")
    public ResponseEntity<?> fecharPedido(@PathVariable Long id) {

        PedidoDTO pedidoDTO = new PedidoDTO(pedidoService.fecharPedido(id));
        return ResponseEntity.ok().body(pedidoDTO);
    }
}