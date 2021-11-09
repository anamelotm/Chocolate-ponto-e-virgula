import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cliente } from '../shared/models/cliente';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  private readonly url = 'http://localhost:3000/clientes';
  constructor(private http: HttpClient) { }

  listar(){
    return this.http.get<Cliente[]>(this.url);
  }
}
