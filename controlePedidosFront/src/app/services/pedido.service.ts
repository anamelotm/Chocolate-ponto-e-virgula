import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pedido } from '../shared/models/pedido';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {

  private readonly url = 'http://localhost:8080/pedidos/';

  constructor(private http: HttpClient) { }
 

  listarPedidos(page: string){
    return this.http.get<Pedido[]>(this.url + "pageable?page"+ page + "&size=10");
  }

  deletarPedido(id: String): Observable<any>{
    return this.http.delete(this.url + id);
  }

  salvarPedido(Pedido: Pedido): Observable<any> {
    return this.http.post(this.url, Pedido);
  }

  getPedido(id: String): Observable<any> {
    return this.http.get(this.url + id);
  }

  editarPedido(id: number, pedido: Pedido): Observable<any>{
    return this.http.put(this.url + id, pedido);
  }

  fechaStatus(id:number):  Observable<any>{
    return this.http.patch(this.url +"fecharpedido/"+ id, id);}


}
