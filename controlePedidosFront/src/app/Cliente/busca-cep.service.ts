import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Endereco } from './model/endereco';

@Injectable({
  providedIn: 'root'
})
export class BuscaCEPService {
  cep = "52040020" ; //document.getElementById("cep")?.textContent;

  private readonly url = 'http://viacep.com.br/ws/'+ this.cep +'/json/';

  constructor(private http: HttpClient) { }

  buscarCEP(){
    
      return this.http.get<Endereco>(this.url);

  }
}
