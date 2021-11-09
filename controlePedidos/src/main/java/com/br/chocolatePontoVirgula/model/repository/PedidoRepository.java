package com.br.chocolatePontoVirgula.model.repository;

import com.br.chocolatePontoVirgula.model.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
