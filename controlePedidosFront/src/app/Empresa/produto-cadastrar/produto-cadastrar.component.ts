import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-produto-cadastrar',
  templateUrl: './produto-cadastrar.component.html',
  styleUrls: ['./produto-cadastrar.component.css']
})
export class ProdutoCadastrarComponent implements OnInit {

  produtoForm: FormGroup;

  constructor(private fb: FormBuilder) { 
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
  }

}
