package com.br.chocolatePontoVirgula.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.br.chocolatePontoVirgula.model.entity.Cliente;
import com.br.chocolatePontoVirgula.model.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@PostMapping
	public void save(@RequestBody Cliente cliente){
		clienteRepository.save(cliente);
	}

	@PutMapping("/{id}")
	public void update(@PathVariable Long id, @RequestBody Cliente cliente){
		Cliente clientePesquisado = clienteRepository.getById(id);

		if(clientePesquisado != null){
			clientePesquisado.setNome(cliente.getNome());
			clienteRepository.save(clientePesquisado);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		Cliente cliente = clienteRepository.findById(id).get();
		return ResponseEntity.ok().body(cliente);
	}

	@GetMapping("/all")
	public ResponseEntity<Page<Cliente>> findAll( Pageable pageable) {

		int size = 10;
		PageRequest pageRequest = PageRequest.ofSize(size);

		Page<Cliente> result = clienteRepository.findAll(pageRequest);
		return ResponseEntity.ok(result);
	}
}
