
import { Component, OnChanges, OnInit, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {map} from 'rxjs/operators';
import { Endereco } from '../model/endereco';
import { BuscaCEPService } from '../busca-cep.service';

@Component({
  selector: 'app-fazer-pedido',
  templateUrl: './fazer-pedido.component.html',
  styleUrls: ['./fazer-pedido.component.css']
})
export class FazerPedidoComponent {
 enderecoBuscado : Endereco | undefined;
 @ViewChild('testecep')  cepteste: any;

cepDigitado: string = "";
  constructor(private servico: BuscaCEPService) { }
    
    pegarcep(){
      console.log('cep aqui' + this.cepDigitado);
      this.servico.buscarCEP(this.cepDigitado).subscribe(objeto => 
        {this.enderecoBuscado = objeto;
        console.log (objeto)});
        if(this.enderecoBuscado == undefined) {
          this.enderecoBuscado={
                      cep: "", 
                      logradouro: "CEP INVÁLIDO", 
                      complemento: "", 
                      bairro: "",
                      localidade: "",
                      uf: "",
                      ibge: "",
                      gia: "",
                      ddd: "",
                      siafi: ""}
    
    
          } 
    }

  }





