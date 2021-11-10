import { Component, OnInit } from '@angular/core';
import { Produto } from '../../shared/models/produto';
import { HomeService } from '../../core/home.service';

@Component({
  selector: 'app-produtos-listar',
  templateUrl: './produtos-listar.component.html',
  styleUrls: ['./produtos-listar.component.css']
})
export class ProdutosListarComponent implements OnInit {

  produtos: Produto[] = [];
  estado: boolean = false;


  constructor(private servico: HomeService) { }

  ngOnInit(): void {
    this.servico.listarProdutos().subscribe(objetos => this.produtos = objetos);
    this.produtos.map(produto => this.estado = produto.status);
    console.log(this.estado);
  }



}
