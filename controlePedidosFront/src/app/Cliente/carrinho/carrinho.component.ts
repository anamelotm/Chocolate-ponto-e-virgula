import { Component, OnInit } from '@angular/core';
import { CarrinhoService } from '../../services/carrinho.service';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-carrinho',
  templateUrl: './carrinho.component.html',
  styleUrls: ['./carrinho.component.css']
})
export class CarrinhoComponent implements OnInit {

  carrinhoForm?: FormGroup;
  public produtos: any = [];
  public grandTotal: number = 0;

  constructor(
    private service: CarrinhoService,
    private fb: FormBuilder,
    private router: Router) { }

  ngOnInit(): void {
    this.service.getProducts().subscribe(res => {
      this.produtos = res;
      this.grandTotal = this.service.getTotalPrice();
      console.log(this.grandTotal);
    })
  }



  removeItem(item: any){
    this.service.removeCartItem(item);
  }

  emptyCart(){
    this.service.removeAllCart();
  }

}
