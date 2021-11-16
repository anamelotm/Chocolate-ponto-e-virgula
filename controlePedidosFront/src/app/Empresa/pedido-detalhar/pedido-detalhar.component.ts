import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ItemPedidoService } from 'src/app/services/item-pedido.service';
import { PedidoService } from 'src/app/services/pedido.service';
import { ItemPedido } from 'src/app/shared/models/item-pedido';
import { Pedido } from 'src/app/shared/models/pedido';

@Component({
  selector: 'app-pedido-detalhar',
  templateUrl: './pedido-detalhar.component.html',
  styleUrls: ['./pedido-detalhar.component.css']
})
export class PedidoDetalharComponent implements OnInit {
  id: string | null;
  pedido: any ;
  itens:ItemPedido[] = [];
  cod : String = "";
 

  constructor(private servico: ItemPedidoService, private pedidoService : PedidoService,  private aRouter: ActivatedRoute)
   {
    this.id = aRouter.snapshot.paramMap.get('id');
    }
  ngOnInit(): void {
    this.servico.listarItens().subscribe(obj => this.itens = obj ); 
    if(this.id!== null) this.pedidoService.getPedido(this.id).subscribe(data =>{this.pedido = data;})
  }




}


