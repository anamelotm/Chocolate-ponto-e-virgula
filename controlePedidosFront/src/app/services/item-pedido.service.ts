import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ItemPedido } from '../shared/models/item-pedido';

@Injectable({
  providedIn: 'root'
})
export class ItemPedidoService {

  private readonly url = 'http://localhost:8080/itens-pedidos/';
  constructor(private http: HttpClient) { }

 
  listarItens(){
    return this.http.get<ItemPedido[]>(this.url + "all/");
  }

  deletarItem(id: String): Observable<any>{
    return this.http.delete(this.url + id);
  }

  salvarItem(item : ItemPedido): Observable<any> {
    return this.http.post(this.url, item);
  }

  getItem(id: String): Observable<any> {
    return this.http.get(this.url + id);
  }
}
