package com.br.chocolatePontoVirgula.controller;

import com.br.chocolatePontoVirgula.model.entity.Produto;
import com.br.chocolatePontoVirgula.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoController produtoController;

   /* @GetMapping(value = "/lista-produtos")
    public ResponseEntity<Page<Produto>> findAll(PageRequest pageRequest) {
        PageRequest.ofSize(10);

        Page<Produto> result = ProdutoRepository.findAll(pageRequest);
        return ResponseEntity.ok(result);
    } */
}
