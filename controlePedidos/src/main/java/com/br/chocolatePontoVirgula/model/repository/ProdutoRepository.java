package com.br.chocolatePontoVirgula.model.repository;

import com.br.chocolatePontoVirgula.model.entity.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    //metodo que lista apenas os produtos ativos
    List<Produto> findByStatusTrue();

    //metodo baixaEstoque
    @Modifying
    @Query("UPDATE Produto p SET p.quantidadeEstoque = :quantidadeEstoque WHERE p.id = :id")
    Produto baixaEstoque(@Param("id") Long id, @Param("quantidadeEstoque") Integer quantidadeEstoque);
}
