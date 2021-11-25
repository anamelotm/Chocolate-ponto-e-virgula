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
  page : number =0;

  constructor(private servico: ClienteService,
    private toastr:ToastrService) { }

  ngOnInit(): void {
    this.getClientes('0');
    this.servico.getTotalPaginas().subscribe(obj => {
     this.paginasBotoes= [];
      this.totalPages = obj;
      for(let i=0; i< obj; i++){
        this.paginasBotoes.push(i);
      }
    })
  };
  ngOnChanges(){
    this.getClientes(this.page.toString());
  }

  getClientes(page: string) {
    this.servico.listarClientesPag(page).subscribe(data => {
      this.clientes = data;
    })
  }

  deletarCliente(codigo: any){
    this.servico.deletarCliente(codigo).subscribe(data => {
      this.toastr.error('O cliente foi excluído com sucesso', 'Cliente deletado');
      this.ngOnInit();
    }, error => {
      if(error.status == 200){
        this.toastr.success('Cliente!', 'Cliente excluido com sucesso');
        this.ngOnInit();
      } else if (error.status == 400){
        this.toastr.error(error.error);
      } else {
          this.toastr.error(error.error);
      }
    })

  }
}
