package com.br.chocolatePontoVirgula.model.repository;


import com.br.chocolatePontoVirgula.model.entity.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByStatusTrue();

    //@OneToMany(mappedBy = "pedido")
    //private List<item_Pedido> itens;
}
