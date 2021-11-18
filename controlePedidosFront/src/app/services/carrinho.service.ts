import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { ProdutoCadastrarComponent } from '../Empresa/produto-cadastrar/produto-cadastrar.component';

@Injectable({
  providedIn: 'root'
})
export class CarrinhoService {

  public cartItemList: any = [];
  public productList = new BehaviorSubject<any>([]);


  constructor() { }

  getProducts(){
    return this.productList.asObservable();
  }

  setProduct(product: any){
    this.cartItemList.push(...product);
    this.productList.next(product);
  }

  addtoCart(product: any){
    this.cartItemList.push(product);
    this.productList.next(this.cartItemList);
    this.getTotalPrice();
  }

  getTotalPrice(){
    let grandTotal = 0;
    this.cartItemList.map((i:any) => {
      grandTotal += i.total;
    })
  }

  removeCartItem(product: any){
    this.cartItemList.map((i: any, index: any) => {
      if(product.id === i.id){
        this.cartItemList.splice(index, 1);
      }
    })
  }

  removeAllCart() {
    this.cartItemList = [];
    this.productList.next(this.cartItemList);
  }

}
