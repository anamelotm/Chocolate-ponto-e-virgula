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
  page: string = "0";
  totalPages = 3;

  constructor(private servico: PedidoService, private toastr: ToastrService,
    private pedidoService :PedidoService,
    private router:Router) { }

  ngOnInit(): void {
    this.buscaPaginado('0');
  }

  alteraStatus(id: any){
    this.servico.fechaStatus(id).subscribe(obj =>{
      this.toastr.success('O pedido foi fechado com êxito', 'Pedido fechado');
    });
    this.ngOnInit();
  }

    buscaPaginado(pag: string){
      this.servico.listarPedidos(pag).subscribe(obj => this.pedidos = obj );
      console.log("chamou o " + pag)
    }
}
