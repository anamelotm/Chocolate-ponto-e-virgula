import { Component, OnInit, Input } from '@angular/core';
import { ProdutoService } from 'src/app/services/produto.service';
import { Produto } from 'src/app/shared/models/produto';
import { CarrinhoService } from '../../../services/carrinho.service';
import { FormGroup, FormBuilder,Validators } from '@angular/forms';

@Component({
  selector: 'app-item-produto',
  templateUrl: './item-produto.component.html',
  styleUrls: ['./item-produto.component.css']
})
export class ItemProdutoComponent implements OnInit {


  produtos: Produto[] = [];
  itemPedidoForm: FormGroup;



  constructor(
    private servico: ProdutoService,
    private cartService: CarrinhoService,
    private fb: FormBuilder,
   ) {
     this.itemPedidoForm = this.fb.group({
       quantidade: ['', Validators.required],
     })
    }



  ngOnInit(): void {
    this.servico.listarProdutosAtivos().subscribe(obj => {
      this.produtos = obj;

      this.produtos.forEach((a:any) => {
        Object.assign(a, {quantity:1, total:a.valorUnitario});
      });

    })
  }

  addToCart(item: any){
      item.quantity = this.itemPedidoForm.get('quantidade')?.value;
      this.cartService.addtoCart(item);
  }
}
