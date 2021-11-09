import { Component, OnInit } from '@angular/core';
import { Cliente } from '../../shared/models/cliente';
import { HomeService } from '../../core/home.service';

@Component({
  selector: 'app-cliente-listar',
  templateUrl: './cliente-listar.component.html',
  styleUrls: ['./cliente-listar.component.css']
})

export class ClienteListarComponent implements OnInit {
  clientes: Cliente[] = [];

  constructor(private servico: HomeService) { }

  ngOnInit(): void {
    this.servico.listar().subscribe(objetos => this.clientes = objetos);
    };
  }
