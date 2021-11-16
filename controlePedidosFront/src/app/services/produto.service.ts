import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Produto } from '../shared/models/produto';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {


  //!!!atualizar o endereço!!!
  url='http://localhost:4000/api/cliente';

  private readonly ulrProduto = 'http://localhost:3000/produtos';

  constructor(private http: HttpClient) { }

  getProduto(): Observable<any> {
    return this.http.get(this.url);
  }

  listarProdutos(){
    return this.http.get<Produto[]>(this.ulrProduto);
  }

}
