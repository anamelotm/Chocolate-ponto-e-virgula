import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Produto } from 'src/app/shared/models/produto';

@Component({
  selector: 'app-produto-cadastrar',
  templateUrl: './produto-cadastrar.component.html',
  styleUrls: ['./produto-cadastrar.component.css']
})
export class ProdutoCadastrarComponent implements OnInit {

  produtoForm: FormGroup;

  constructor(private fb: FormBuilder,
               private router: Router,
              private toastr: ToastrService) {

    this.produtoForm = this.fb.group({
      nome: ['', Validators.required],
      descricao: ['', Validators.required],
      unidade_medida: ['', Validators.required],
      peso: ['', Validators.required],
      valor_unitario: ['', Validators.required],
      url_fotos: ['', Validators.required],
      data_fabricacao: ['', Validators.required],
      data_validade: ['', Validators.required],
      quantidade_estoque: ['', Validators.required]

    })
  }

  ngOnInit(): void {
  }

  cadastrarProduto(){
    console.log(this.produtoForm);

    const produto: Produto = {
      nome: this.produtoForm.get('nome')?.value,
      descricao: this.produtoForm.get('descricao')?.value,
      unidade_medida: this.produtoForm.get('unidade_medida')?.value,
      peso: this.produtoForm.get('peso')?.value,
      valor_unitario: this.produtoForm.get('valor_unitario')?.value,
      url_fotos: this.produtoForm.get('url_fotosme')?.value,
      data_fabricacao: this.produtoForm.get('data_fabricacao')?.value,
      data_validade: this.produtoForm.get('data_validade')?.value,
      quantidade_estoque: this.produtoForm.get('quantidade_estoque')?.value,
      id: 0,
      status: true
    }

    console.log(produto);
    this.toastr.success('Produto Registrado com Sucesso!', 'Cadastro Concluído!')
    this.router.navigate(['/'])
  }

}
