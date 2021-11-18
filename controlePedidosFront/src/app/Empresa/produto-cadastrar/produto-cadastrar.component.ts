import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ProdutoService } from 'src/app/services/produto.service';
import { Produto } from 'src/app/shared/models/produto';

@Component({
  selector: 'app-produto-cadastrar',
  templateUrl: './produto-cadastrar.component.html',
  styleUrls: ['./produto-cadastrar.component.css']
})
export class ProdutoCadastrarComponent implements OnInit {

  //produtoForm: FormGroup;
  produto: Produto = {
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
  constructor(private fb: FormBuilder,
               private router: Router,
              private toastr: ToastrService, private servico: ProdutoService) {
  }

  ngOnInit(): void {
  }

  create(): void {
    this.servico.create(this.produto).subscribe((resposta) =>{
      console.log(resposta);
      this.toastr.success('Produto Registrado com Sucesso!', 'Cadastro Concluído!')
      this.router.navigate(['/produtos-listar'])
    }, erro => {
      for(let i = 0; i < erro.error.errors.length; i++) {
        this.toastr.error(erro.error.errors[i].message);
        //mostra a mensagem de erro do console
      }      
    })
  }

  cancel(): void {
    this.router.navigate(['/produtos-listar']);
  }
}
