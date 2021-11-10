package com.br.chocolatePontoVirgula.controller;

import com.br.chocolatePontoVirgula.model.entity.Cliente;
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
@RequestMapping(path = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;
/*
* Codigo  			int 		not null auto_increment primary key,
	data_Pedido -		DateTime 	not null,
	Codigo_cliente - 		int 		not null,
	endereco_Entrega - 	varchar (150),
	Situacao 		-	boolean 	not null,
	valor_Total - 		double (8,2) not null,
	quantidade_Total -	int 		not null,
	percentual_Desconto - int
* */
    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody
    String addNewUser(@RequestParam Date dataPedido
            , @RequestParam int codigoCliente, @RequestParam int percentualDesconto,
                      @RequestParam boolean situacao,@RequestParam String enderecoEntrega,
                      @RequestParam double valorTotal,@RequestParam int quantidadeTotal) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Pedido pedido = new Pedido();
        pedido.setDataPedido(dataPedido);
        pedido.setCodigoCliente(codigoCliente);
        pedido.setPercentualDesconto(percentualDesconto);
        pedido.setSituacao(situacao);
        pedido.setEnderecoEntrega(enderecoEntrega);
        pedido.setValorTotal(valorTotal);
        pedido.setQuantidadeTotal(quantidadeTotal);
        pedidoRepository.save(pedido);
        return "Saved";
    }

    @GetMapping("/all")
    public ResponseEntity<Page<Pedido>> ListAll(Pageable pageable) {

        int size = 10;
        PageRequest pageRequest = PageRequest.ofSize(size);

        Page<Pedido> result = pedidoRepository.findAll(pageRequest);
        return ResponseEntity.ok(result);
    }

}