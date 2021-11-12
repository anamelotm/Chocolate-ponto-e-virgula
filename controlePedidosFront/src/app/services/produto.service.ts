import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Produto } from '../shared/models/produto';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  private readonly ulrProduto = 'http://localhost:3000/produtos/';

  constructor(private http: HttpClient) { }

  getProduto(): Observable<any> {
    return this.http.get(this.ulrProduto);
  }

  listarProdutos(){
    return this.http.get<Produto[]>(this.ulrProduto);
  }

}
