
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {map} from 'rxjs/operators';
import { Endereco } from '../model/endereco';
import { BuscaCEPService } from '../busca-cep.service';

@Component({
  selector: 'app-fazer-pedido',
  templateUrl: './fazer-pedido.component.html',
  styleUrls: ['./fazer-pedido.component.css']
})
export class FazerPedidoComponent implements OnInit {
 enderecoBuscado : Endereco | undefined;


  constructor(private servico: BuscaCEPService) { }

  ngOnInit(): void {
    this.servico.buscarCEP().subscribe(objeto => {this.enderecoBuscado = objeto;
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





