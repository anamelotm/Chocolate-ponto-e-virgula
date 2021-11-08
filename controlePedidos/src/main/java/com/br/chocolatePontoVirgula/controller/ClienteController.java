package com.br.chocolatePontoVirgula.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.chocolatePontoVirgula.model.entity.Cliente;
import com.br.chocolatePontoVirgula.model.repository.ClienteRepository;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping(value = "/lista-clientes")
	public ResponseEntity<Page<Cliente>> findAll(PageRequest pageRequest) {
		PageRequest.ofSize(10);
		
	    Page<Cliente> result = clienteRepository.findAll(pageRequest);
	    return ResponseEntity.ok(result);
	}
	
	

}
