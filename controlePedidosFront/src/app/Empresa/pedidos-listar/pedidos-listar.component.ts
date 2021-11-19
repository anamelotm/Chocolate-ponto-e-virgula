import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { PedidoService } from 'src/app/services/pedido.service';
import { Pedido } from 'src/app/shared/models/pedido';

@Component({
  selector: 'app-pedidos-listar',
  templateUrl: './pedidos-listar.component.html',
  styleUrls: ['./pedidos-listar.component.css']
})
export class PedidosListarComponent implements OnInit {
  pedidos: Pedido[] = [];

  constructor(private servico: PedidoService, private toastr: ToastrService,
    private pedidoService :PedidoService,
    private router:Router) { }

  ngOnInit(): void {
    this.servico.listarPedidos().subscribe(obj => this.pedidos = obj );
  }

    
  // alterarStatus(id: number, pedido:Pedido){
  
  //   if(pedido.situacao== true){
  //     pedido.situacao = false;
  //     this.pedidoService.editarPedido( cod, pedido ).subscribe(data => {
  //       this.toastr.info('Situação do pedido atualizada com sucesso!', 'Situação atualizada');
  //       this.router.navigate(['/pedidos-listar']); 
  //     })
      
  //   }

  // } ***** falta coverter a id para String
}
