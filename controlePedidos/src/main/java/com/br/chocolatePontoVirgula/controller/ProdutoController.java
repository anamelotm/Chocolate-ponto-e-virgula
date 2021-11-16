package com.br.chocolatePontoVirgula.controller;


import com.br.chocolatePontoVirgula.model.entity.Produto;
import com.br.chocolatePontoVirgula.model.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

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

    @GetMapping("/all")
    public ResponseEntity<Page<Produto>> findAll( Pageable pageable) {
        return produtoService.findAll(pageable);
    }

    @PatchMapping("/{id}")
    public void inativar(@PathVariable Long id){
        produtoService.inativar(id);
    }

}
