package com.br.model.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    Cliente cliente=new Cliente();

    @Test
    void validarCPF() {

        String cpf="000.000.000-00";
        //String cpf="111.111.111-11";
        //String cpf="222.222.222-22";
        //String cpf="333.333.333-33";
        //String cpf="444.444.444-44";
        //String cpf="555.555.555-55";
        //String cpf="666.666.666-66";
        //String cpf="777.777.777-77";
        //String cpf="888.888.888-88";
        //String cpf="999.999.999-99";
        if(cliente.validarCPF(cpf)) {
            System.out.println("cpf válido");
        }
        else {
            System.out.println("cpf inválido");
        }
    }


    @Test
    void validarCNPJ() {
        if(cliente.validarCNPJ("13.109.636/0001-70")){
            System.out.println("CNPJ válido");
        }
        else{
            System.out.println("CNPJ inválido");
        }
    }
}