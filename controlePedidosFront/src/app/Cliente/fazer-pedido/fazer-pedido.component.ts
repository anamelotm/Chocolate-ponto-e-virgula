
import { Component, OnInit } from '@angular/core';
import { Endereco } from '../../shared/models/Endereco';
import { BuscaCEPService } from '../../services/busca-cep.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { PedidoService } from 'src/app/services/pedido.service';
import { Pedido } from 'src/app/shared/models/pedido';

@Component({
  selector: 'app-fazer-pedido',
  templateUrl: './fazer-pedido.component.html',
  styleUrls: ['./fazer-pedido.component.css']
})
export class FazerPedidoComponent implements OnInit{
  titulo = "Finalizando seu Pedido";
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


  constructor(
    private servico: BuscaCEPService,
    private fb: FormBuilder,
    private router:Router,
    private toastr: ToastrService,
    private pedidoService: PedidoService,
    private aRouter: ActivatedRoute
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

    }

    ngOnInit(): void{
    }

    pegarcep(){
        this.servico.buscarCEP(this.cepDigitado).subscribe(objeto => this.enderecoBuscado = objeto);
    }

<<<<<<< HEAD

    efetuarPedido(){
      const pedido: Pedido ={
        id: this.pedidoForm.get('')?.value ,
        nome: this.pedidoForm.get('nome')?.value,
        enderecoEntrega: this.enderecoBuscado.logradouro + ", " +this.pedidoForm.get('complemento')?.value + ", "+
                          this.enderecoBuscado.bairro + ", " + this.enderecoBuscado.localidade + "-"+ this.enderecoBuscado.uf +"CEP: "+ this.enderecoBuscado.cep,
  
        aberto: true,
        subtotal: 100,
        desconto: 10,
        total: 90
=======
    salvarPedido(id: number){
      const pedido: Pedido = {
        idCliente: this.pedidoForm.get('cliente')?.value,
        enderecoEntrega: this.enderecoBuscado.logradouro + ", " +this.pedidoForm.get('complemento')?.value + ", "+
                          this.enderecoBuscado.bairro + ", " + this.enderecoBuscado.localidade + "-"+ this.enderecoBuscado.uf +"CEP: "+ this.enderecoBuscado.cep,
>>>>>>> feature/ana.melo
      }
      this.pedidoService.editarPedido(id, pedido).subscribe(data => {
        this.toastr.info('Pedido efetuado com sucesso!');
          this.router.navigate(['/']);
      }, error => {
        console.log(error);
      });

    }
}


