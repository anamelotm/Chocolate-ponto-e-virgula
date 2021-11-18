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
      unidade_medida: ['', Validators.required],
      peso: ['', Validators.required],
      valor_unitario: ['', Validators.required],
      url_fotos: ['', Validators.required],
      data_fabricacao: ['', Validators.required],
      data_validade: ['', Validators.required],
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
      this.produtoForm.controls['unidade_medida'].errors ||
      this.produtoForm.controls['peso'].errors ||
      this.produtoForm.controls['valor_unitario'].errors ||
      this.produtoForm.controls['url_fotos'].errors ||
      this.produtoForm.controls['data_fabricacao'].errors ||
      this.produtoForm.controls['data_validade'].errors ||
      this.produtoForm.controls['quantidade_estoque'].errors) {
      console.log(this.produtoForm);
    } else {

      //criando um produto
      const produto: Produto = {
        id: this.produtoForm.get('')?.value,
        nome: this.produtoForm.get('nome')?.value,
        descricao: this.produtoForm.get('descricao')?.value,
        unidade_medida: this.produtoForm.get('unidade_medida')?.value,
        peso: this.produtoForm.get('peso')?.value,
        valorUnitario: this.produtoForm.get('valorUnitario')?.value,
        url_fotos: this.produtoForm.get('url_fotos')?.value,
        data_fabricacao: this.produtoForm.get('data_fabricacao')?.value,
        data_validade: this.produtoForm.get('data_validade')?.value,
        quantidade_estoque: this.produtoForm.get('quantidade_estoque')?.value,
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
