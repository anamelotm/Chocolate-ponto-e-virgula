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


    public ResponseEntity<String> save(Cliente cliente){
        boolean docValido = false;

        //validando o o documento antes de realizar o insert no banco
        if(cliente.getTipo().equals("Física")){
           docValido = validarCPF(cliente.getDocumento());
        } else if (cliente.getTipo().equals("Jurídica")){
            docValido = validarCNPJ(cliente.getDocumento());
        }

        if(docValido){
            clienteRepository.save(cliente);
            return ResponseEntity.ok().body("cliente criado");
        } else {
            return  ResponseEntity.badRequest().body("Aqui haverá uma exceção");
            // TODO: rever aqui, metodos http não estão funcionando corretamente

        }

    }


    public void update( Long id, Cliente cliente){
        Cliente clientePesquisado = clienteRepository.getById(id);

        if(clientePesquisado != null){
            clientePesquisado.setNome(cliente.getNome());
            clienteRepository.save(clientePesquisado);
        }
    }



    public void delete(Long id){

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
