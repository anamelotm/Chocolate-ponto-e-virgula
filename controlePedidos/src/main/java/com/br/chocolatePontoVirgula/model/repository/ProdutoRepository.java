package com.br.chocolatePontoVirgula.model.repository;

import com.br.chocolatePontoVirgula.model.entity.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    //metodo que lista apenas os produtos ativos
    List<Produto> findByStatusTrue();

    //metodo que atualiza o estoque
    @Transactional
    @Modifying
    @Query("UPDATE Produto p SET p.quantidadeEstoque = p.quantidadeEstoque - :quantidadeComprada WHERE p.id = :id")
    void atualizarEstoque(@Param("id") Long id, @Param("quantidadeComprada") Integer quantidadeComprada);

    //metodo que verifica o estoque do produto
    @Query("SELECT p FROM Produto p WHERE id = :id")
    Produto verificarEstoque(@Param("id") Long id);
}