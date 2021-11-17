import { ProdutoService } from './../../services/produto.service';
import { Component, OnInit } from '@angular/core';
import { Produto } from '../../shared/models/produto';

@Component({
  selector: 'app-produtos-listar',
  templateUrl: './produtos-listar.component.html',
  styleUrls: ['./produtos-listar.component.css']
})
export class ProdutosListarComponent implements OnInit {

  produtos: Produto[] = [];
  estado: boolean = false;


  constructor(private servico: ProdutoService) { }
  ngOnInit(): void { 
    //this.servico.listarProdutos().subscribe(obj => this.listaProdutos = obj);
    this.findAll();
  }

  findAll() {
    this.servico.findAll().subscribe(resposta => {
      console.log(resposta)
      this.produtos = resposta;
    })
  }
}
