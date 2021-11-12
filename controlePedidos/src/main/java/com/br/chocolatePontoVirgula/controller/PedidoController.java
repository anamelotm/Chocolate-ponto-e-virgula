package com.br.chocolatePontoVirgula.controller;

import com.br.chocolatePontoVirgula.model.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.br.chocolatePontoVirgula.model.entity.Pedido;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping
    public @ResponseBody
    String addNewUser(@RequestParam Date dataPedido
            , @RequestParam int codigoCliente, @RequestParam int percentualDesconto,
                      @RequestParam boolean aberto,@RequestParam String enderecoEntrega,
                      @RequestParam double valorTotal,@RequestParam int quantidadeTotal) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Pedido pedido = new Pedido();
        pedido.setDataPedido(dataPedido);
        pedido.setCodigoCliente(codigoCliente);
        pedido.setPercentualDesconto(percentualDesconto);
        pedido.setAberto(aberto);
        pedido.setEnderecoEntrega(enderecoEntrega);
        pedido.setValorTotal(valorTotal);
        pedido.setQuantidadeTotal(quantidadeTotal);
        pedidoRepository.save(pedido);
        return "Saved";
    }

    @GetMapping
    public ResponseEntity<Page<Pedido>> ListAll(Pageable pageable) {

        int size = 10;
        PageRequest pageRequest = PageRequest.ofSize(size);

        Page<Pedido> result = pedidoRepository.findAll(pageRequest);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/{codigo}")
    public void excluir(@PathVariable int codigo){
        pedidoRepository.deleteById(codigo);
    }
    @PutMapping("/{codigo}")
    public void alterar(@PathVariable int codigo, @RequestBody Pedido pedido){
        Pedido pedidoPesquisado = pedidoRepository.getOne(codigo);
        if(pedidoPesquisado != null){
            pedidoPesquisado.setAberto(pedido.isAberto());
            pedidoRepository.save(pedidoPesquisado);
        }
    }
}