import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cliente } from '../shared/models/cliente';
import { Produto } from '../shared/models/produto';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  private readonly urlCliente = 'http://localhost:3000/clientes';
  private readonly urlProduto = 'http://localhost:3000/produtos';
  constructor(private http: HttpClient) { }

  listarClientes(){
    return this.http.get<Cliente[]>(this.urlCliente);
  }

  listarProdutos(){
    return this.http.get<Produto[]>(this.urlProduto);
  }
}
