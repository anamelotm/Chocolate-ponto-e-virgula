package com.br.chocolatePontoVirgula.model.services;

import com.br.chocolatePontoVirgula.model.entity.Cliente;
import com.br.chocolatePontoVirgula.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public void save(Cliente cliente){
        clienteRepository.save(cliente);
    }


    public void update( Long id, Cliente cliente){
        Cliente clientePesquisado = clienteRepository.getById(id);

        if(clientePesquisado != null){
            clientePesquisado.setNome(cliente.getNome());
            clienteRepository.save(clientePesquisado);
        }
    }

    public void excluir(Long id){
        clienteRepository.deleteById(id);
    }


    public ResponseEntity<Cliente> findById(Long id) {
        Cliente cliente = clienteRepository.findById(id).get();
        return ResponseEntity.ok().body(cliente);
    }


    public ResponseEntity<Page<Cliente>> findAll(Pageable pageable) {

        int size = 10;
        PageRequest pageRequest = PageRequest.ofSize(size);

        Page<Cliente> result = clienteRepository.findAll(pageRequest);
        return ResponseEntity.ok(result);
    }
}
