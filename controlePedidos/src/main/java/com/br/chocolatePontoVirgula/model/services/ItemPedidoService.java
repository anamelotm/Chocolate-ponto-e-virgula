package com.br.chocolatePontoVirgula.model.services;


import com.br.chocolatePontoVirgula.model.entity.ItemPedido;

import com.br.chocolatePontoVirgula.model.form.ItemPedidoForm;
import com.br.chocolatePontoVirgula.model.repository.ItemPedidoRepository;
import com.br.chocolatePontoVirgula.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    ProdutoRepository produtoRepository;


    public void save(@Validated @RequestBody ItemPedidoForm itemPedidoForm) throws URISyntaxException {
        //pegando os dados do form e inserindo em um ItemPedido:
        ItemPedido itemPedido = new ItemPedido();

        itemPedido.setIdPedido(itemPedidoForm.getIdPedido());
        itemPedido.setProduto(itemPedidoForm.getProduto());
        itemPedido.setQuantidade(itemPedidoForm.getQuantidade());
        itemPedido.setValorTotal(itemPedidoForm.getValorTotal());

        //verificacao de estoque antes de salvar o item pedido:
        URI uri = new URI("http://localhost:8080/produto/estoque/" + itemPedido.getProduto().getId());
        ResponseEntity<Integer> qnt = ResponseEntity.created(uri).body(itemPedido.getProduto().getQuantidadeEstoque());
        if(itemPedido.getQuantidade() <= qnt.getBody()){
            itemPedidoRepository.save(itemPedido);
            
        } else {
            //TODO: terminar aqui!! (add excecao)
            //TODO: voltar aqui!! está sando erro
        }


    }


  public void update( Long id, ItemPedido itemPedido){
       ItemPedido itemPedidoPesquisado = itemPedidoRepository.getById(id);

       if(itemPedidoPesquisado != null){
            itemPedidoPesquisado.setQuantidade(itemPedido.getQuantidade());
            itemPedidoRepository.save(itemPedidoPesquisado);
       }
   }


    public void delete(Long id){
        itemPedidoRepository.deleteById(id);
    }


    public ResponseEntity<ItemPedido> findById(Long id) {
        ItemPedido itemPedido = itemPedidoRepository.findById(id).get();
        return ResponseEntity.ok().body(itemPedido);
    }


    public Page<ItemPedido> findAll(Pageable pageable) {

       return itemPedidoRepository.findAll(pageable);

    }

    public  List<ItemPedido> itensDoPedido(Long idPedido){
        List<ItemPedido> itemPedido = itemPedidoRepository.itensDoPedido(idPedido);
        return itemPedido;
    }
}
