import { ProdutoService } from './../../services/produto.service';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { CarrinhoDialogComponent } from './carrinho-dialog/carrinho-dialog.component';
import { Produto } from '../../shared/models/produto';
import { MessengerService } from 'src/app/services/messenger.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  produtos: Produto[] = [];

  constructor(public dialog: MatDialog,
      private servico: ProdutoService,
      private msg: MessengerService) {
   }

  ngOnInit(): void {
    this.servico.listarProdutos().subscribe(obj => this.produtos = obj);
  }

 carrinho(): void {
    const dialogRef = this.dialog.open(CarrinhoDialogComponent, {
      width: '400px',
      height: 'auto'
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');

    });

  }

}
