package com.br.chocolatePontoVirgula.controller;

import com.br.chocolatePontoVirgula.model.dto.ClienteDTO;
import com.br.chocolatePontoVirgula.model.entity.Cliente;
import com.br.chocolatePontoVirgula.model.form.ClienteForm;
import com.br.chocolatePontoVirgula.model.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	@PostMapping
	public ResponseEntity<String> save(@Validated @RequestBody  ClienteForm cliente){
		return clienteService.save(cliente);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Cliente cliente){
		return clienteService.update(id, cliente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		return clienteService.delete(id);
	}

	@GetMapping("/{id}")
	public Cliente findById(@PathVariable Long id) {
		 return clienteService.findById(id);
	}

	@GetMapping("pageable")
	public List<ClienteDTO> findAll(Pageable pageable) {
		Page<Cliente> clientesLista=clienteService.findAll(pageable);
		return ClienteDTO.converter(clientesLista);
	}
	@GetMapping("totaldepaginas")
	public int retornaTotalPaginas(){
		Pageable pageable=PageRequest.of(0,10);
		Page<Cliente> clientesLista = clienteService.findAll(pageable);
		return clientesLista.getTotalPages();
	}
}
