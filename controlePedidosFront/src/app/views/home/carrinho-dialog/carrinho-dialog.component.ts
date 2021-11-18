import { Component, OnInit } from '@angular/core';
import { MatDialogRef, MatDialogModule } from '@angular/material/dialog';
import { Subscription } from 'rxjs';
import { MessengerService } from 'src/app/services/messenger.service';
import { Produto } from 'src/app/shared/models/produto';
import { ItemPedido } from '../../../shared/models/item-pedido';

@Component({
  selector: 'app-carrinho-dialog',
  templateUrl: './carrinho-dialog.component.html',
  styleUrls: ['./carrinho-dialog.component.css']
})
export class CarrinhoDialogComponent implements OnInit {

  itensCarrinho: ItemPedido[] = [
    {id:100, produto: 'Teste 1', valorUnitario: 50.0, quantidade: 4, valorTotalItem: 100},
  
  ];

  totalCarrinho = 0;

  constructor(
    public dialogRef: MatDialogRef<CarrinhoDialogComponent>,
    private msg: MessengerService
  ) { }

  ngOnInit() {
      this.msg.getMsg().subscribe(produto => {
      console.log(produto)
      this.addProductToCart(produto)
      })
  }

  addProductToCart(produto: Produto){
      this.itensCarrinho.push({
        id: 1,
        produto: produto.nome,
        valorUnitario: produto.valorUnitario,
        quantidade: 1,
        valorTotalItem: 100
      })

    this.totalCarrinho = 0;
    this.itensCarrinho.forEach(item => {
      this.totalCarrinho += (item.quantidade * item.valorTotalItem)
    })
  }

  cancelar(): void {
    this.dialogRef.close();
  }
}
