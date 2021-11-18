import { Cliente } from './../../shared/models/cliente';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ClienteService } from '../../services/cliente.service';

@Component({
  selector: 'app-cliente-cadastrar',
  templateUrl: './cliente-cadastrar.component.html',
  styleUrls: ['./cliente-cadastrar.component.css']
})
export class ClienteCadastrarComponent implements OnInit {
  clienteForm: FormGroup;
  titulo = 'Cadastrar cliente';
  id: string | null;

  constructor(private fb: FormBuilder,
                private router: Router,
                private toastr: ToastrService,
                private clienteService: ClienteService,
                private aRouter: ActivatedRoute) {
    this.clienteForm = this.fb.group({
      nome: ['', Validators.required],
      tipo: ['', Validators.required],
      documento: ['', Validators.required]
    })
    this.id = aRouter.snapshot.paramMap.get('id');
   }

  ngOnInit(): void {
    this.isEditar();
  }

  cadastrarCliente(){
    if(this.clienteForm.controls['nome'].errors || this.clienteForm.controls['documento'].errors || this.clienteForm.controls['tipo'].errors) {
     console.log(this.clienteForm);
    } else{

      //criando um cliente
      const cliente: Cliente = {
        id: this.clienteForm.get('')?.value,
        nome: this.clienteForm.get('nome')?.value,
        tipo: this.clienteForm.get('tipo')?.value,
        documento: this.clienteForm.get('documento')?.value
      }

      if(this.id !== null){
        //editando o cliente
        this.clienteService.editarCliente(this.id, cliente).subscribe(data => {
          this.toastr.info('Cliente atualizado com sucesso!', 'Cliente atualizado');
          this.router.navigate(['/cliente-listar']);
        }, error => {
          console.log(error);
          this.clienteForm.reset();
        })
      } else{

        //metodo para gravar no banco
        this.clienteService.salvarCliente(cliente).subscribe(data => {
          this.toastr.success('Cliente cadastrado com sucesso!', 'Cadastro concluído!');
          this.router.navigate(['/']);
        }, error => {
          console.log(error);
          this.clienteForm.reset();
        })
      }
    }
  }

  isEditar(){
    if(this.id !== null){
      this.titulo = 'Editar cliente';
      this.clienteService.getCliente(this.id).subscribe(data => {
        this.clienteForm.setValue({
          nome: data.nome,
          tipo: data.tipo,
          documento: data.documento
        })
      })
    }
  }

}
