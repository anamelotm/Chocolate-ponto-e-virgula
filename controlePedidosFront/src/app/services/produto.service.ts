import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Produto } from '../shared/models/produto';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ToastrService } from 'ngx-toastr';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  url='http://localhost:8080/produtos/';

  constructor(private http: HttpClient, private toastr: ToastrService) { }
  
  listarProdutos(page: string){
    return this.http.get<Produto[]>(this.url + "pageable?page=" + page + "&size=10");
  }

  listarProdutosAtivos(){
    return this.http.get<Produto[]>(this.url + 'ativos');
  }

  deletarProduto(id: String): Observable<any>{
    return this.http.delete(this.url + id);
  }

  salvarProduto(produto: Produto): Observable<any> {
    return this.http.post(this.url, produto);
  }

  getProduto(id: String): Observable<any> {
    return this.http.get(this.url + id);
  }

  editarProduto(id: string,produto: Produto): Observable<any> {
    return this.http.put(this.url + id, produto);
  }

  getTotalPaginas(): Observable<any>{
    return this.http.get(this.url + "totaldepaginas");
  }
}
