import { ClienteService } from './../../services/cliente.service';
import { Component, OnChanges, OnInit } from '@angular/core';
import { Cliente } from '../../shared/models/cliente';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-cliente-listar',
  templateUrl: './cliente-listar.component.html',
  styleUrls: ['./cliente-listar.component.css']
})

export class ClienteListarComponent implements OnInit, OnChanges {
  clientes: Cliente[] = [];
  totalPages: number = 0;
  paginasBotoes: number[] = [];

  constructor(private servico: ClienteService,
    private toastr:ToastrService) { }

  ngOnInit(): void {
    this.getClientes('0');
    this.servico.getTotalPaginas().subscribe(obj => {
      this.totalPages = obj;
      for(let i=0; i< obj; i++){
        this.paginasBotoes.push(i);
      }
    })
  };

  getClientes() {
    this.servico.listarClientes().subscribe(data => {
      this.clientes = data;
    })
  }


  deletarCliente(codigo: any){
    this.servico.deletarCliente(codigo).subscribe(data => {
      this.toastr.error('O cliente foi eliminado com êxito', 'Cliente eliminado');
      this.ngOnInit();
    }, error => {
      console.log(error);
    })

}
}
