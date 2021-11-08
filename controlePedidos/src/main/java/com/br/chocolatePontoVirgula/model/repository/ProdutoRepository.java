package com.br.chocolatePontoVirgula.model.repository;

import com.br.chocolatePontoVirgula.model.entity.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {


}
