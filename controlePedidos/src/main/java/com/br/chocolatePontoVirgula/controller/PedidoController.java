package com.br.chocolatePontoVirgula.controller;

import com.br.chocolatePontoVirgula.model.dto.PedidoDTO;
import com.br.chocolatePontoVirgula.model.dto.PedidosDTO;
import com.br.chocolatePontoVirgula.model.form.PedidoForm;
import com.br.chocolatePontoVirgula.model.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public Long salvar(@Validated @RequestBody PedidoForm pedidoForm, BindingResult result) {
        Pedido pedido = new Pedido();
        pedidoForm.setDataPedido(pedido.getDataAtual());
        pedidoForm.setAberto(true);
        pedidoForm.setPercentualDesconto(0);
        Pedido pedidoSalvo = pedidoService.save(pedidoForm);
        return pedidoSalvo.getId();
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
    public PedidoDTO findById(@PathVariable Long id) {
        PedidoDTO pedidoDTO = new PedidoDTO(pedidoService.findById(id));
        return pedidoDTO;
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
    public void fecharPedido(@PathVariable Long id) {
        pedidoService.fecharPedido(id);
    }
}