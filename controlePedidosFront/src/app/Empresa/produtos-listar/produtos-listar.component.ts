import { ProdutoService } from './../../services/produto.service';
import { Component, OnInit } from '@angular/core';
import { Produto } from '../../shared/models/produto';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-produtos-listar',
  templateUrl: './produtos-listar.component.html',
  styleUrls: ['./produtos-listar.component.css']
})
export class ProdutosListarComponent implements OnInit {

  produtos: Produto[] = [];

  constructor(private servico: ProdutoService, 
    private toastr:ToastrService) { }


  ngOnInit(): void {
    this.servico.listarProdutos().subscribe(obj => this.produtos = obj);
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
