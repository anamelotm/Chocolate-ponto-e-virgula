package com.br.chocolatePontoVirgula.controller;


import com.br.chocolatePontoVirgula.model.dto.ClienteDTO;
import com.br.chocolatePontoVirgula.model.dto.ProdutoDTO;
import com.br.chocolatePontoVirgula.model.entity.Cliente;
import com.br.chocolatePontoVirgula.model.entity.Produto;
import com.br.chocolatePontoVirgula.model.repository.ProdutoRepository;
import com.br.chocolatePontoVirgula.model.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    //salva o produto
    @PostMapping
    public void save(@RequestBody Produto produto){
        produtoService.save(produto);
    }

    //altera o produto por id
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Produto produto){
        produtoService.update(id, produto);
    }

    //deleta o produto
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        produtoService.delete(id);
    }

    //encontra o produto por id
    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        return produtoService.findById(id);
    }

    @GetMapping("pageable")
    public List<ProdutoDTO> findAll(Pageable pageable) {
        Page<Produto> produtosLista = produtoService.findAll(pageable);
        return ProdutoDTO.converter(produtosLista);
    }

    @GetMapping("totaldepaginas")
    public int retornaTotalpaginas(){
        Pageable pageable= PageRequest.of(0,10);
        Page<Produto> produtosLista = produtoService.findAll(pageable);
        return produtosLista.getTotalPages();
    }

    //inativar o produto
    @PatchMapping("/{id}")
    public void inativar(@PathVariable Long id){
        produtoService.inativar(id);
    }

    //atualiza o estoque
    @PutMapping("atualizarestoque/{id}")
    public void atualizarEstoque(@PathVariable Long id, @RequestBody Produto p) {
        produtoService.atualizarEstoque(id, p);}

    //consulta apenas os produtos ativos
    @GetMapping("/ativos")
    public List<Produto> consultaProdutosAtivos(){
        return produtoService.consultaProdutosAtivos();
    }

    //consulta o estoque do produto
    @GetMapping("/estoque/{id}")
    public Integer verificarEstoque(@PathVariable Long id){
        return produtoService.verificarEstoque(findById(id).getBody());
    }

}
