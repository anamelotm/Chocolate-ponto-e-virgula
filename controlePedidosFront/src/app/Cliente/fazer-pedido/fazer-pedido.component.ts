
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
  titulo = "Finalizando seu Pedido 🛒";
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
      this.isEditar();
    }
    
    isEditar(){
      if(this.id !== null){
        this.titulo = "Editando Endereço de Entrega";
        this.pedidoService.getPedido(this.id).subscribe(data => 
          this.pedidoForm.patchValue({  //altero setValue para patch pois nao vou usar todos os atributos.
            cliente: data.cliente,
          }))
      }
    }
    pegarcep(){
        this.servico.buscarCEP(this.cepDigitado).subscribe(objeto => this.enderecoBuscado = objeto);
    }


    efetuarPedido(){
      const pedido: Pedido ={
        id: this.pedidoForm.get('')?.value ,
        cliente: this.pedidoForm.get('cliente')?.value,
        enderecoEntrega: this.enderecoBuscado.logradouro + ", " +this.pedidoForm.get('complemento')?.value + ", "+
                          this.enderecoBuscado.bairro + ", " + this.enderecoBuscado.localidade + "-"+ this.enderecoBuscado.uf +"CEP: "+ this.enderecoBuscado.cep,
  
        aberto: true,
        subtotal: 100,
        desconto: 10,
        total: 90
      }

      if(this.id !== null){
        this.pedidoService.editarPedido(this.id, pedido).subscribe(data => {
          this.toastr.info('Endereço de entrega atualizado com sucesso!', 'Pedido atualizado');
          this.router.navigate(['/pedidos-listar']);
        }, error => {
          console.log(error);
          this.pedidoForm.reset();
        })
      } else{
      

      this.pedidoService.salvarPedido(pedido).subscribe(data => {
        this.toastr.success('Pedido efetuado com sucesso!', 'Pedido efetuado!');
        this.router.navigate(['/']);
      }, error => {
        console.log(error);
        this.pedidoForm.reset();
      })
    }}
}


