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

@Component({
  selector: 'app-fazer-pedido',
  templateUrl: './fazer-pedido.component.html',
  styleUrls: ['./fazer-pedido.component.css']
})
export class FazerPedidoComponent implements OnInit{
  titulo = "Finalizando seu Pedido";
  clientes: Cliente[] = [];

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
  id: string | null;
  idPedido: number = 0;


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
      this.id = aRouter.snapshot.paramMap.get('id');
      this.aRouter.params.subscribe(params => this.idPedido = params['id']);
    }

    ngOnInit(): void{
      this.getClientes();
    }

    getClientes() {
      this.servicoCliente.listarClientes().subscribe(data => {
        this.clientes = data;
        console.log(this.clientes);
      })
    }

    pegarcep(){
        this.servico.buscarCEP(this.cepDigitado).subscribe(objeto => this.enderecoBuscado = objeto);
    }

    salvarPedido(){
      const pedido: Pedido = {
        idCliente: this.pedidoForm.get('cliente')?.value,
        enderecoEntrega: this.enderecoBuscado.logradouro + ", " +this.pedidoForm.get('complemento')?.value + ", "+
                          this.enderecoBuscado.bairro + ", " + this.enderecoBuscado.localidade + "-"+ this.enderecoBuscado.uf +"CEP: "+ this.enderecoBuscado.cep,
      }
      this.pedidoService.editarPedido(this.idPedido, pedido).subscribe(data => {
        this.toastr.info('Pedido efetuado com sucesso!');
          this.router.navigate(['/']);
      }, error => {
        console.log(error);
      });

    }
}


