import { ClienteService } from './../../services/cliente.service';
import { Component, OnInit } from '@angular/core';
import { Cliente } from '../../shared/models/cliente';

@Component({
  selector: 'app-cliente-listar',
  templateUrl: './cliente-listar.component.html',
  styleUrls: ['./cliente-listar.component.css']
})

export class ClienteListarComponent implements OnInit {
  clientes: Cliente[] = [];

  constructor(private servico: ClienteService) { }

  ngOnInit(): void {
    this.servico.listarClientes().subscribe(obj => this.clientes = obj)
    };
  }
