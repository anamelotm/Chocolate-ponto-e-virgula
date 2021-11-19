package com.br.chocolatePontoVirgula.model.repository;


import com.br.chocolatePontoVirgula.model.entity.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    //metodo que lista apenas os produtos ativos
    List<Produto> findByStatusTrue();

}
