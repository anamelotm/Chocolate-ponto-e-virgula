import { Component, OnInit, Input } from '@angular/core';
import { MessengerService } from 'src/app/services/messenger.service';
import { ProdutoService } from 'src/app/services/produto.service';
import { Produto } from 'src/app/shared/models/produto';

@Component({
  selector: 'app-item-produto',
  templateUrl: './item-produto.component.html',
  styleUrls: ['./item-produto.component.css']
})
export class ItemProdutoComponent implements OnInit {


  produtos: Produto[] = [];

  constructor(private msg: MessengerService,
    private servico: ProdutoService) { }

  ngOnInit(): void {
    this.servico.listarProdutos().subscribe(obj => this.produtos = obj);
  }


}
