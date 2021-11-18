import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Endereco } from '../shared/models/Endereco';

@Injectable({
  providedIn: 'root'
})
export class BuscaCEPService {
  
  private baseUrl = 'http://viacep.com.br/ws/';
  private url = "";

  constructor(private http: HttpClient) { }

  buscarCEP(inputCep: string){
    this.url = this.baseUrl + inputCep + '/json/';
      return this.http.get<Endereco>(this.url);

  }
}
