import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { ItemPedidoService } from 'src/app/services/item-pedido.service';
import { ItemPedido } from 'src/app/shared/models/item-pedido';

@Component({
  selector: 'app-pedido-detalhar',
  templateUrl: './pedido-detalhar.component.html',
  styleUrls: ['./pedido-detalhar.component.css']
})
export class PedidoDetalharComponent implements OnInit {

 itens:ItemPedido[] = [];

  constructor(private servico: ItemPedidoService, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.servico.listarItens().subscribe(obj => this.itens = obj );
  }

}


