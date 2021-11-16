import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-carrinho-item',
  templateUrl: './carrinho-item.component.html',
  styleUrls: ['./carrinho-item.component.css']
})
export class CarrinhoItemComponent implements OnInit {

  @Input() itemCarrinho: any;
  constructor() { }

  ngOnInit(): void {
  }

}
