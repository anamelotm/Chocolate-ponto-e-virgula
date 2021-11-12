import { Component, OnInit } from '@angular/core';
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

  constructor(private servico: PedidoService, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.servico.listarPedidos().subscribe(obj => this.pedidos = obj );
  }

}
