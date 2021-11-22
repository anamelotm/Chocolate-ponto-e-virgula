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
  itens: any;
  cod : String = "";
 

  constructor(private servico: ItemPedidoService, private pedidoService : PedidoService,  private aRouter: ActivatedRoute, private toastr:ToastrService)
   {
    this.id = aRouter.snapshot.paramMap.get('id');
    }
  ngOnInit(): void {
    if(this.id!== null) {
    this.servico.getItensPedido(this.id).subscribe(obj => this.itens = obj ); 
      this.pedidoService.getPedido(this.id).subscribe(data =>this.pedido = data);
  }}

  deletarItem(codigo: any){
    this.servico.deletarItem(codigo).subscribe(data => {
      this.toastr.error('O item foi excluído do pedido com êxito', 'Item Excluído');
      this.ngOnInit();
    }, error => {
      console.log(error);
    })
}





}


