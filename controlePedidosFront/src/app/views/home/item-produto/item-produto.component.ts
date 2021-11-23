import { Component, OnInit, Input } from '@angular/core';
import { ProdutoService } from 'src/app/services/produto.service';
import { Produto } from 'src/app/shared/models/produto';
import { CarrinhoService } from '../../../services/carrinho.service';

@Component({
  selector: 'app-item-produto',
  templateUrl: './item-produto.component.html',
  styleUrls: ['./item-produto.component.css']
})
export class ItemProdutoComponent implements OnInit {


  produtos: Produto[] = [];

  constructor(
    private servico: ProdutoService,
    private cartService: CarrinhoService
   ) { }

  ngOnInit(): void {
    this.servico.listarProdutosAtivos().subscribe(obj => {
      this.produtos = obj;

      this.produtos.forEach((a:any) => {
        Object.assign(a, {quantity:1, total:a.valorUnitario});
      });
    })
  }

  addToCart(item: any){
    this.cartService.addtoCart(item);
  }
}
