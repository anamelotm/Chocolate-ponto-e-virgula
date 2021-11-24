import { Component, OnChanges, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { PedidoService } from 'src/app/services/pedido.service';
import { Pedido } from 'src/app/shared/models/pedido';

@Component({
  selector: 'app-pedidos-listar',
  templateUrl: './pedidos-listar.component.html',
  styleUrls: ['./pedidos-listar.component.css']
})
export class PedidosListarComponent implements OnInit , OnChanges{
  pedidos: any;
  totalPages: number  = 0;
  page: number = 0;
  paginasBotoes: number[]= [];


  constructor(private servico: PedidoService, private toastr: ToastrService,
    private pedidoService :PedidoService,
    private router:Router) {

     }

  ngOnInit(): void {
    this.page = 0;
    this.getPedidos(this.page.toString());
    this.servico.getTotalPaginas().subscribe(obj => {
      this.totalPages= obj;
      for(let i=0; i<obj; i++){
        this.paginasBotoes.push(i);
      }
    });


  }

  alteraStatus(id: any){
    this.servico.fechaStatus(id).subscribe(obj =>{
      this.toastr.success('O pedido foi fechado com êxito', 'Pedido fechado');
      this.ngOnInit();
    });
  }
  ngOnChanges(){
  this.getPedidos(this.page.toString());
  }

  getPedidos(pag: string){
   this.servico.listarPedidos(pag).subscribe(obj => this.pedidos = obj );
  }

}
