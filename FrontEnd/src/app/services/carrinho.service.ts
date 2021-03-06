import { Injectable, EventEmitter } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { ProdutoCadastrarComponent } from '../Empresa/produto-cadastrar/produto-cadastrar.component';
import { Pedido } from '../shared/models/pedido';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CarrinhoService {

  public cartItemList: any = [];
  public produtos = new BehaviorSubject<any>([]);
  public pedido: Pedido = {
    cliente: {
      id: 0,
      tipo: '',
      documento: '',
      nome: ''
    }
   };

  idPedidoCriado = new EventEmitter<number>();


  private readonly url = 'http://localhost:8080/pedidos/';

  constructor(private http: HttpClient) { }

  getProducts(){
    return this.produtos.asObservable();
  }

  setProduct(produto: any){
    this.cartItemList.push(...produto);
    this.produtos.next(produto);
  }

  addtoCart(produto: any){
    this.cartItemList.push(produto);
    this.produtos.next(this.cartItemList);
    this.getTotalPrice();
  }

  getTotalPrice(): number{
    let grandTotal = 0;
    this.cartItemList.map((i:any) => {
      grandTotal += i.total;
    })
    return grandTotal;
  }

  removeCartItem(produto: any){
    this.cartItemList.map((i: any, index: any) => {
      if(produto.id === i.id){
        this.cartItemList.splice(index, 1);
      }
    })
    this.produtos.next(this.cartItemList);
  }

  removeAllCart() {
    this.cartItemList = [];
    this.produtos.next(this.cartItemList);
  }

  save(pedido: Pedido): Observable<any>{
    return this.http.post(this.url, pedido);
  }

  emitirIdCriado(idPedido: number) {
    this.idPedidoCriado.emit(idPedido);
  }

}
