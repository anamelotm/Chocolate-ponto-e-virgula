import { ProdutoService } from './../../services/produto.service';
import { Component, OnChanges, OnInit } from '@angular/core';
import { Produto } from '../../shared/models/produto';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-produtos-listar',
  templateUrl: './produtos-listar.component.html',
  styleUrls: ['./produtos-listar.component.css']
})
export class ProdutosListarComponent implements OnInit, OnChanges {

  produtos: Produto[] = [];
  totalPages: number = 0;
  paginasBotoes: number[] = [];

  constructor(private servico: ProdutoService, 
    private toastr:ToastrService) { }

  ngOnInit(): void {
    this.getProdutos('0');
    this.servico.getTotalPaginas().subscribe(obj =>{
      this.totalPages = obj;
      for(let i = 0; i < obj; i++){
        this.paginasBotoes.push(i);
      }
    });
  }

  ngOnChanges(){
    this.getProdutos('1');
  }

  getProdutos(page: string){
    this.servico.listarProdutos(page).subscribe(data => {
      this.produtos = data});
      console.log(this.produtos);
  }

  deletarProduto(codigo: any){
    this.servico.deletarProduto(codigo).subscribe(data => {
      this.toastr.error('Produto Excluído!', 'Item excluido com sucesso');
      this.ngOnInit();
    }, error => {
      console.log(error);
    })
  }
}
