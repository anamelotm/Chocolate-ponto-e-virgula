
import { Component } from '@angular/core';
import { Endereco } from '../../shared/models/Endereco';
import { BuscaCEPService } from '../../services/busca-cep.service';

@Component({
  selector: 'app-fazer-pedido',
  templateUrl: './fazer-pedido.component.html',
  styleUrls: ['./fazer-pedido.component.css']
})
export class FazerPedidoComponent {
 enderecoBuscado : Endereco = {
  cep: "", 
  logradouro: "", 
  complemento: "", 
  bairro: "",
  localidade: "",
  uf: "",
  ibge: "",
  gia: "",
  ddd: "",
  siafi: ""};

cepDigitado: string = "";
  constructor(private servico: BuscaCEPService) { }
    
    pegarcep(){
        this.servico.buscarCEP(this.cepDigitado).subscribe(objeto => this.enderecoBuscado = objeto);
    }

    

}
