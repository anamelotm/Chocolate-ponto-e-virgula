import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ProdutoService } from 'src/app/services/produto.service';
import { Produto } from 'src/app/shared/models/produto';

@Component({
  selector: 'app-produto-cadastrar',
  templateUrl: './produto-cadastrar.component.html',
  styleUrls: ['./produto-cadastrar.component.css']
})
export class ProdutoCadastrarComponent implements OnInit {
  produtoForm: FormGroup;
  titulo = 'Cadastrar Produto';
  id: string | null;


  constructor(private fb: FormBuilder,
    private router: Router, private aRouter: ActivatedRoute,
    private toastr: ToastrService, private produtoService: ProdutoService) {

    this.produtoForm = this.fb.group({
      nome: ['', Validators.required],
      descricao: ['', Validators.required],
      unidadeMedida: ['', Validators.required],
      peso: ['', Validators.required],
      valorUnitario: ['', Validators.required],
      urlFotos: ['', Validators.required],
      dataFabricacao: ['', Validators.required],
      dataValidade: ['', Validators.required],
      quantidade: ['', Validators.required],
      status: true
    })
    this.id = aRouter.snapshot.paramMap.get('id');
  }

  ngOnInit(): void {
    this.isEditar();
  }
  cadastrarProduto() {
    if (this.produtoForm.controls['nome'].errors ||
      this.produtoForm.controls['descricao'].errors ||
      this.produtoForm.controls['unidadeMedida'].errors ||
      this.produtoForm.controls['peso'].errors ||
      this.produtoForm.controls['valorUnitario'].errors ||
      this.produtoForm.controls['urlFotos'].errors ||
      this.produtoForm.controls['dataFabricacao'].errors ||
      this.produtoForm.controls['dataValidade'].errors ||
      this.produtoForm.controls['quantidadeEstoque'].errors) {
      console.log(this.produtoForm);
    } else {

      //criando um produto
      const produto: Produto = {
        id: this.produtoForm.get('')?.value,
        nome: this.produtoForm.get('nome')?.value,
        descricao: this.produtoForm.get('descricao')?.value,
        unidadeMedida: this.produtoForm.get('unidadeMedida')?.value,
        peso: this.produtoForm.get('peso')?.value,
        valorUnitario: this.produtoForm.get('valorUnitario')?.value,
        urlFotos: this.produtoForm.get('urlFotos')?.value,
        dataFabricacao: this.produtoForm.get('dataFabricacao')?.value,
        dataValidade: this.produtoForm.get('dataValidade')?.value,
        quantidadeEstoque: this.produtoForm.get('quantidadeEstoque')?.value,
        status: true
      }

      if (this.id !== null) {

        //editando o produto
        this.produtoService.editarProduto(this.id, produto).subscribe(data => {
          this.toastr.info('Produto atualizado com sucesso!', 'Produto atualizado');
          this.router.navigate(['/produtos-listar']);
        }, error => {
          console.log(error);
          this.produtoForm.reset();
        })

      } else {

        //metodo para gravar no banco
        this.produtoService.salvarProduto(produto).subscribe(data => {
          this.toastr.success('Produto cadastrado com sucesso!', 'Cadastro concluído!');
          this.router.navigate(['/']);
        }, error => {
          console.log(error);
          this.produtoForm.reset();
        })
      }
    }
  }



  isEditar() {
    if (this.id !== null) {
      this.titulo = 'Editar produto';
      this.produtoService.getProduto(this.id).subscribe(data => {
        this.produtoForm.setValue({
          valor_unitario: data.valor_unitario,
          status: data.status,
          quantidade_estoque: data.quantidade_estoque
        })
      })
    }
  }
}
