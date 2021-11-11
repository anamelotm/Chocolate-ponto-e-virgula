import { ThisReceiver } from '@angular/compiler';
import { Component, OnInit, NgModule } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';



@Component({
  selector: 'app-cliente-cadastrar',
  templateUrl: './cliente-cadastrar.component.html',
  styleUrls: ['./cliente-cadastrar.component.css']
})
export class ClienteCadastrarComponent implements OnInit {
  clienteForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.clienteForm = this.fb.group({
      nome: ['', Validators.required],
      tipo: ['', Validators.required],
      documento: ['', Validators.required]
    })
   }

  ngOnInit(): void {
  }

  cadastrarCliente(){
    if(this.clienteForm.controls['nome'].errors || this.clienteForm.controls['documento'].errors || this.clienteForm.controls['tipo'].errors) {
     console.log(this.clienteForm);
    } else{
      Swal.fire({
          icon: 'success',
          title: 'Cadastro concluído!',
          confirmButtonColor: 'blue'
        });

        const cliente: Cliente = {
          nome: this.clienteForm.get('nome')?.value,

        }
    console.log(this.clienteForm);
    }
  }

}
