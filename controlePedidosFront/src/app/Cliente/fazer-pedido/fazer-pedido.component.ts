import { Cliente } from './../../shared/models/cliente';

import { Component, OnInit } from '@angular/core';
import { Endereco } from '../../shared/models/Endereco';
import { BuscaCEPService } from '../../services/busca-cep.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { PedidoService } from 'src/app/services/pedido.service';
import { Pedido } from 'src/app/shared/models/pedido';
import { ClienteService } from '../../services/cliente.service';
import { CarrinhoService } from '../../services/carrinho.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-fazer-pedido',
  templateUrl: './fazer-pedido.component.html',
  styleUrls: ['./fazer-pedido.component.css']
})
export class FazerPedidoComponent implements OnInit{
  titulo = "Finalizando seu Pedido";
  clientes: Cliente[] = [];
  idPedido: string | null = '';
  pedidoCriado: Pedido = {
    cliente: {
      id: 0,
      nome:'',
      tipo:'',
      documento: ''
    }
  };
  valorTotal: number = 0;
  quantidadeItens: number = 0;

  enderecoBuscado : Endereco = {
    cep: "",
    logradouro: "",
    complemento: "",
    bairro: "",
    localidade: "",
    uf: "",
    ibge: "",
    gia: "",
    ddd: "",
    siafi: ""};

  cepDigitado: string = "";
  pedidoForm: FormGroup;


  constructor(
    private servico: BuscaCEPService,
    private fb: FormBuilder,
    private router:Router,
    private toastr: ToastrService,
    private pedidoService: PedidoService,
    private aRouter: ActivatedRoute,
    private servicoCliente: ClienteService
    ) {
      this.pedidoForm = this.fb.group({
        cliente:['', Validators.required],
        rua:['', Validators.required],
        bairro:['', Validators.required],
        cidade:['', Validators.required],
        uf:['', Validators.required],
        complemento:['', Validators.required]
      })

      this.idPedido = this.aRouter.snapshot.paramMap.get('id');

    }


    ngOnInit(): void{
      this.getClientes();
      this.getPedido();
    }

    getClientes() {
      this.servicoCliente.listarClientes().subscribe(data => {
        this.clientes = data;
      })
    }

    getPedido(){
      this.pedidoService.getPedido(this.idPedido).subscribe(data => {
        this.valorTotal = data.valorTotal;
        this.quantidadeItens = data.quantidadeTotal;
      })
    }

    pegarcep(){
        this.servico.buscarCEP(this.cepDigitado).subscribe(objeto => this.enderecoBuscado = objeto);
    }

    salvarPedido(){
      const pedido: Pedido = {
        cliente : {
          id: this.pedidoForm.get('cliente')?.value,
          nome: "",
          tipo: "",
          documento: ""
        },
        enderecoEntrega: this.enderecoBuscado.logradouro + ", " +this.pedidoForm.get('complemento')?.value + ", "+
                          this.enderecoBuscado.bairro + ", " + this.enderecoBuscado.localidade + "-"+ this.enderecoBuscado.uf +"CEP: "+ this.enderecoBuscado.cep,
      }

      this.pedidoService.editarPedido(Number(this.idPedido), pedido).subscribe(data => {
        this.toastr.info('Pedido efetuado com sucesso!');
          this.router.navigate(['/']);
      }, error => {
        console.log(error);
      });

    }
}


