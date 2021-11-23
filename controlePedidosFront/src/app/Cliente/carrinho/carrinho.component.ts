import { Component, OnInit } from '@angular/core';
import { CarrinhoService } from '../../services/carrinho.service';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { ItemPedido } from '../../shared/models/item-pedido';
import { ItemPedidoService } from '../../services/item-pedido.service';
import { Produto } from 'src/app/shared/models/produto';
import { Pedido } from '../../shared/models/pedido';
import { PedidoService } from '../../services/pedido.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-carrinho',
  templateUrl: './carrinho.component.html',
  styleUrls: ['./carrinho.component.css']
})
export class CarrinhoComponent implements OnInit {

  carrinhoForm?: FormGroup;
  public produtos: any = [];
  public grandTotal: number = 0;
  public idPedido: number = 0;

  constructor(
    private service: CarrinhoService,
    private serviceIP: ItemPedidoService,
    private fb: FormBuilder,
    private router: Router,
    private servicePedido: PedidoService) { }

  ngOnInit(): void {
    this.service.getProducts().subscribe(res => {
      this.produtos = res;
      this.produtos.map((item:any) => {
        item.total = item.valorUnitario * item.quantity;
      })
      this.grandTotal = this.service.getTotalPrice();
    })
  }


  removeItem(item: any){
    this.service.removeCartItem(item);
  }

  emptyCart(){
    this.service.removeAllCart();
  }

  finalizarCarrinho(valorTotal: number){
    const pedido = {
      valorTotal: valorTotal,
      quantidadeTotal: this.produtos.length
    }
    this.service.save(pedido).subscribe(data => {
      this.idPedido = data;
      this.router.navigate(['/fazer-pedido'])
      console.log(data);
      this.salvarItem(data);
    }, error => {
      console.log(error)
    });

  }

  salvarItem(idPedido: number){
    let itemPedido: ItemPedido;
    this.produtos.map( (item: any) => {
     itemPedido = {
      idPedido: idPedido,
      produto: {
        id: item.id
      },
      valorTotal: item.total,
      quantidade: item.quantity
     }
     this.serviceIP.salvarItem(itemPedido).subscribe(data => {
       this.router.navigate(['/fazer-pedido'])
      }, error => {
        console.log(error)
      });
    })

    this.emptyCart();
  }
}
