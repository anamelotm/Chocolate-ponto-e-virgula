package com.br.chocolatePontoVirgula.model.services;

import com.br.chocolatePontoVirgula.model.entity.Cliente;
import com.br.chocolatePontoVirgula.model.form.ClienteForm;
import com.br.chocolatePontoVirgula.model.repository.ClienteRepository;
import com.br.chocolatePontoVirgula.model.services.exceptions.EntityNotCreatedException;
import com.br.chocolatePontoVirgula.model.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public ResponseEntity<String> save(@Validated ClienteForm clienteForm){
        //pegando os dados do clienteForm e atribuindo a um Cliente:
        Cliente cliente = new Cliente();
        cliente.setNome(clienteForm.getNome());
        cliente.setTipo(clienteForm.getTipo());
        cliente.setDocumento(clienteForm.getDocumento());


        boolean docValido = false;

        //validando o o documento antes de realizar o insert no banco
        if(cliente.getTipo().equals("Física")){
            docValido = validarCPF(cliente.getDocumento());
        } else if (cliente.getTipo().equals("Jurídica")){
            docValido = validarCNPJ(cliente.getDocumento());
        }

        //verificando se o cliente já está cadastrado no banco:
        Cliente cliPesquisado = clienteRepository.alreadyExist(cliente.getDocumento());

        if(docValido && cliPesquisado == null){
            clienteRepository.save(cliente);
            return ResponseEntity.ok().body("Cliente criado com sucesso!");
        } else {
            return  ResponseEntity.badRequest().body("Não foi possível cadastrar o cliente. Insira um documento válido ou verifique se esse docuento está associado um cliente já cadastrado.");


        }

    }


    public ResponseEntity<String> update(Long id, Cliente cliente){
        Cliente clientePesquisado = clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado."));

        clientePesquisado.setNome(cliente.getNome());
        clienteRepository.save(clientePesquisado);
        return ResponseEntity.ok().body("Cliente alterado com sucesso!");

    }



    public ResponseEntity<String> delete(Long id){
        Cliente c = clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado."));
        List<Long> clienteHasPedido = clienteRepository.clienteHasPedido(c.getId());

        if(clienteHasPedido == null){
            clienteRepository.deleteById(c.getId());
            return ResponseEntity.ok().body("Cliente excluído com sucesso!");
        } else {
            return ResponseEntity.badRequest().body("Não foi possível excluir o cliente pois ele está associado a um pedido.");
        }

    }


    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado."));

    }


    public Page<Cliente> findAll(Pageable pageable) {
       return clienteRepository.findAll(pageable);

    }

    public boolean validarCPF(String cpf) {
        if(cpf.equals("000.000.000-00")||cpf.equals("111.111.111-11")||cpf.equals("222.222.222-22")||cpf.equals("333.333.333-33")||cpf.equals("444.444.444-44")||cpf.equals("555.555.555-55")||cpf.equals("666.666.666-66")||cpf.equals("777.777.777-77")||cpf.equals("888.888.888-88")||cpf.equals("999.999.999-99")) {
            return false;
        }
        else {
            String numerosCPF = cpf.replace(".", "");
            numerosCPF = numerosCPF.replace("-", "");
            int soma = 0;
            int indice = 0;
            int resto = 0;
            int digitoVerificado;

            if (numerosCPF.length() == 11) {
                for (int i = 10; i > 1; i--) {
                    soma += Integer.parseInt(numerosCPF.charAt(indice) + "") * i;
                    indice++;
                }
                resto = 11 - (soma % 11);
                if (resto == 10 || resto == 11) {
                    digitoVerificado = 0;
                } else {
                    digitoVerificado = resto;
                }
                if (digitoVerificado == Integer.parseInt("" + numerosCPF.charAt(9))) {
                    indice = 0;
                    soma = 0;
                    resto = 0;
                    for (int i = 11; i > 1; i--) {
                        soma += Integer.parseInt(numerosCPF.charAt(indice) + "") * i;
                        indice++;
                    }
                    resto = 11 - (soma % 11);
                    if (resto == 10 || resto == 11) {
                        digitoVerificado = 0;
                    } else {
                        digitoVerificado = resto;
                    }
                    if (digitoVerificado == Integer.parseInt("" + numerosCPF.charAt(10))) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else
                return false;
        }
    }

    public boolean validarCNPJ(String cnpj) {
        String numerosCNPJ = cnpj.replace(".", "");
        numerosCNPJ = numerosCNPJ.replace("/", "");
        numerosCNPJ = numerosCNPJ.replace("-", "");
        int[] pesosPrimeiroDigitoVerificador = { 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
        int[] pesosSegundoDigitoVerificador = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
        int indice = 0;
        int soma = 0;
        int resto = 0;
        int digito = 0;
        if (numerosCNPJ.length() == 14) {
            for (int i = 0; i < pesosPrimeiroDigitoVerificador.length; i++) {
                soma += Integer.parseInt(numerosCNPJ.charAt(indice) + "") * pesosPrimeiroDigitoVerificador[i];
                indice++;
            }
            resto = soma % 11;
            if (resto < 2) {
                digito = 0;
            } else {
                digito = 11 - resto;
            }
            if (digito == Integer.parseInt(numerosCNPJ.charAt(12) + "")) {
                indice = 0;
                soma = 0;
                resto = 0;
                digito = 0;
                for (int i = 0; i < pesosSegundoDigitoVerificador.length; i++) {
                    soma += Integer.parseInt(numerosCNPJ.charAt(indice) + "") * pesosSegundoDigitoVerificador[i];
                    indice++;
                }
                resto = soma % 11;
                if (resto < 2) {
                    digito = 0;
                } else {
                    digito = 11 - resto;
                }
                if (digito == Integer.parseInt(numerosCNPJ.charAt(13) + "")) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

}
