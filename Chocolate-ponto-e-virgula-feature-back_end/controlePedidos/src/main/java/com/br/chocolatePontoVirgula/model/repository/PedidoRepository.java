package com.br.chocolatePontoVirgula.model.repository;

import com.br.chocolatePontoVirgula.model.dto.PedidosDTO;
import com.br.chocolatePontoVirgula.model.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
   /* @Query("select p.id,c.nome,p.endereco_entrega,p.aberto, p.valor_total from pedido p inner join cliente c on p.id_cliente =c.id")
    List<PedidosDTO> consultaGeralPedidos();*/
}
