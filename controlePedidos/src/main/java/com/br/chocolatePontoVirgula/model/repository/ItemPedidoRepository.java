package com.br.chocolatePontoVirgula.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.chocolatePontoVirgula.model.entity.ItemPedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long>{

//    @Query("SELECT p.nome, p.valorUnitario, i.quantidade, i.valorTotal " +
//            "FROM ItemPedido i " +
//            "INNER JOIN Produto p ON p.id = i.idProduto " +
//            "INNER JOIN Pedido pe ON pe.id = i.idPedido " +
//            "WHERE i.idPedido = :idPedido")
    @Query("SELECT item FROM ItemPedido item WHERE idPedido = :idPedido")
    List<ItemPedido> itensDoPedido(@Param("idPedido") long idPedido);
}
