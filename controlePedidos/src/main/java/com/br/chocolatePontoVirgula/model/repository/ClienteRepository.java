package com.br.chocolatePontoVirgula.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.chocolatePontoVirgula.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
