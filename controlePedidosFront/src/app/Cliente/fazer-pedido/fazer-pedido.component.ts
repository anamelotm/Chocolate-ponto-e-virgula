import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-fazer-pedido',
  templateUrl: './fazer-pedido.component.html',
  styleUrls: ['./fazer-pedido.component.css']
})
export class FazerPedidoComponent implements OnInit {

  cep!: number;
  
  constructor() { }

  ngOnInit(): void {
  }

}



