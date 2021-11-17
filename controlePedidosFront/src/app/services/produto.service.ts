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

  baseUrl: String = environment.baseUrl;

  constructor(private http: HttpClient, private toastr: ToastrService) { }

  findAll():Observable<Produto[]> {
    const url = `${this.baseUrl}/produto`
    return this.http.get<Produto[]>(url);
  }

  create(produto: Produto): Observable<Produto>{
    const url = `${this.baseUrl}/produto`
    return this.http.post<Produto>(url, produto);
  }

  findById(id: string) : Observable<Produto> {
    const url = `${this.baseUrl}/produto/${id}`
    return this.http.get<Produto>(url);
  }

  delete(id: string) : Observable<void> {
    const url = `${this.baseUrl}/produto/${id}`
    return this.http.delete<void>(url);
  }

}
