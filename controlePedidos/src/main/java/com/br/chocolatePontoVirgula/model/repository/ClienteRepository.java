package com.br.chocolatePontoVirgula.model.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import com.br.chocolatePontoVirgula.model.entity.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c WHERE c.documento = :doc")
    Cliente alreadyExist(@Param("doc") String doc);
}
