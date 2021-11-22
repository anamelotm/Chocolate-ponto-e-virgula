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
  pedidos: any;

  constructor(private servico: PedidoService, private toastr: ToastrService,
    private pedidoService :PedidoService,
    private router:Router) { }

  ngOnInit(): void {
    this.servico.listarPedidos().subscribe(obj => this.pedidos = obj );
  }

  alteraStatus(id: any){
    this.servico.fechaStatus(id).subscribe(obj =>{
      this.toastr.success('O pedido foi fechado com êxito', 'Pedido fechado');
    });
    this.ngOnInit();
  }
}
