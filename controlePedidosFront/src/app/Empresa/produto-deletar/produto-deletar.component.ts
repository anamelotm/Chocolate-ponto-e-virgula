import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ProdutoService } from 'src/app/services/produto.service';
import { Produto } from 'src/app/shared/models/produto';

@Component({
  selector: 'app-produto-deletar',
  templateUrl: './produto-deletar.component.html',
  styleUrls: ['./produto-deletar.component.css']
})
export class ProdutoDeletarComponent implements OnInit {

  produto: Produto= {
   
    nome: '',
    descricao: '',
    unidade_medida: '',
    peso: 0.0,
    valor_unitario: 0.0,
    url_fotos: '',
    data_fabricacao: '',
    data_validade: '',
    quantidade_estoque: 0.0,
    id: '',
    status: false
  }
  constructor(private servico: ProdutoService, private router: Router, private route: ActivatedRoute, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.produto.id = this.route.snapshot.paramMap.get('id')!
    this.findById(); 
  }

  findById(): void {
    this.servico.findById(this.produto.id).subscribe((resposta) =>{
      this.produto.nome = resposta.nome;
      this.produto.descricao = resposta.descricao;
      this.produto.unidade_medida = resposta.unidade_medida;
      this.produto.peso = resposta.peso;
      this.produto.valor_unitario = resposta.valor_unitario;
      this.produto.url_fotos = resposta.url_fotos;
      this.produto.data_fabricacao = resposta.data_fabricacao;
      this.produto.data_validade = resposta.data_validade;
      this.produto.data_fabricacao = resposta.data_fabricacao;
      this.produto.quantidade_estoque = resposta.quantidade_estoque;

      console.log(this.produto);
    });
  }

  delete(): void {
    this.servico.delete(this.produto.id!).subscribe((resposta) => {
      this.router.navigate(['/produtos-listar'])
      this.toastr.success('Categoria deletada com Sucesso!');
    });
  }
  
  cancel(): void {
    this.router.navigate(['/produtos-listar']);
  }

}
