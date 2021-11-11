package com.br.chocolatePontoVirgula.controller;

import com.br.chocolatePontoVirgula.model.entity.Produto;
import com.br.chocolatePontoVirgula.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<Page<Produto>> ListAll( Pageable pageable) {

        int size = 10;
        PageRequest pageRequest = PageRequest.ofSize(size);

        Page<Produto> result = produtoRepository.findAll(pageRequest);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public void salvar(@RequestBody Produto produto){
        produtoRepository.save(produto);
    }

    @DeleteMapping("/{codigo}")
    public void excluir(@PathVariable int codigo){
        produtoRepository.deleteById(codigo);
    }

    @PutMapping("/{codigo}")
    public void alterar(@PathVariable int codigo, @RequestBody Produto produto){
        Produto produtoPesquisado = produtoRepository.getOne(codigo);
        if(produtoPesquisado != null){
            produtoPesquisado.setDescricaoProduto(produto.getDescricaoProduto());
            produtoRepository.save(produtoPesquisado);
        }
    }
}