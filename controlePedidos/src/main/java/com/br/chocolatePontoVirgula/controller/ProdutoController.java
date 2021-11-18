package com.br.chocolatePontoVirgula.controller;


import com.br.chocolatePontoVirgula.model.dto.ProdutoDTO;
import com.br.chocolatePontoVirgula.model.entity.Produto;
import com.br.chocolatePontoVirgula.model.repository.ProdutoRepository;
import com.br.chocolatePontoVirgula.model.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    ProdutoRepository produtoRepository;

    @PostMapping
    public void save(@RequestBody Produto produto){
        produtoService.save(produto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Produto produto){
        produtoService.update(id, produto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        produtoService.delete(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        return produtoService.findById(id);
    }

    @GetMapping
    public List<ProdutoDTO> listarTudo(){
        List<Produto> produtosLista = produtoRepository.findAll();
        return ProdutoDTO.converter(produtosLista);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<Produto>> findAll( Pageable pageable) {
        return produtoService.findAll(pageable);
    }

    @PatchMapping("/{id}")
    public void inativar(@PathVariable Long id){
        produtoService.inativar(id);
    }

    @GetMapping("/ativos")
    public List<Produto> consultaProdutosAtivos(){
        return produtoService.consultaProdutosAtivos();
    }

}
