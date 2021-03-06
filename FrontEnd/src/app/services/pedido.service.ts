import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pedido } from '../shared/models/pedido';
import { CarrinhoService } from './carrinho.service';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {

  private readonly url = 'http://localhost:8080/pedidos/';


  constructor(private http: HttpClient,
    private carrinhoService: CarrinhoService) { }

  listarPedidos(page: any){

    return this.http.get<Pedido[]>(this.url + "pageable?page="+ page + "&size=10");
  }

  deletarPedido(id: String): Observable<any>{
    return this.http.delete(this.url + id);
  }

  salvarPedido(Pedido: Pedido): Observable<any> {
    return this.http.post(this.url, Pedido);
  }

  getPedido(id: String | null): Observable<any> {
    return this.http.get(this.url + id);
  }

  editarPedido(id: number, pedido: Pedido): Observable<any>{
    return this.http.patch(this.url + id, pedido);
  }

  fechaStatus(id:number):  Observable<any>{
    return this.http.patch(this.url +"fecharpedido/"+ id, id);}

  getTotalPaginas() : Observable<any>{
    return this.http.get(this.url + "totaldepaginas");
  }



}
