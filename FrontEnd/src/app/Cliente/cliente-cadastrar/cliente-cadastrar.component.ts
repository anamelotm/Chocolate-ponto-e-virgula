import { Cliente } from './../../shared/models/cliente';
import { ChangeDetectorRef, Component, ElementRef, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ClienteService } from '../../services/cliente.service';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-cliente-cadastrar',
  templateUrl: './cliente-cadastrar.component.html',
  styleUrls: ['./cliente-cadastrar.component.css']
})


export class ClienteCadastrarComponent implements OnInit {
  clienteForm: FormGroup;
  titulo = 'Cadastrar cliente';
  id: string | null;
  editar: boolean = false;
  button: string = 'Cadastrar';


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

  cadastrarCliente() {
    if (this.clienteForm.controls['nome'].errors || this.clienteForm.controls['documento'].errors || this.clienteForm.controls['tipo'].errors) {
      console.log(this.clienteForm);
    } else {

      //criando um cliente
      const cliente: Cliente = {
        id: this.clienteForm.get('')?.value,
        nome: this.clienteForm.get('nome')?.value,
        tipo: this.clienteForm.get('tipo')?.value,
        documento: this.clienteForm.get('documento')?.value
      }

      if (this.id !== null) {
        //editando o cliente
        this.clienteService.editarCliente(this.id, cliente).subscribe(data => {
          this.toastr.info('Cliente atualizado com sucesso!', 'Cliente atualizado');
          this.router.navigate(['/cliente-listar']);
        }, error => {
          this.toastr.error('Erro ao editar cliente', 'Erro ao editar!');
          console.log(error);
          this.clienteForm.reset();
        })
      } else {

        //metodo para gravar no banco
        this.clienteService.salvarCliente(cliente).subscribe(data => {
          this.toastr.success('Cliente cadastrado com sucesso!', 'Cadastro concluído!');
          this.router.navigate(['/']);
          console.log(data);
        }, error => {
<<<<<<< HEAD:controlePedidosFront/src/app/Cliente/cliente-cadastrar/cliente-cadastrar.component.ts
          this.toastr.error('Insira um documento válido!', 'Erro no cadastro');
=======
          this.toastr.error(error.error);
          console.log(error);
>>>>>>> f457e626ebd91e53aaf65952ea6b96137e14203f:FrontEnd/src/app/Cliente/cliente-cadastrar/cliente-cadastrar.component.ts
          this.clienteForm.reset();
        })
      }
    }
  }



  isEditar() {
    if (this.id !== null) {
      this.editar = true;
      this.button = 'Salvar';
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

  validarCpf(cpf: string): boolean {
    if (cpf === "000.000.000-00" || cpf === "111.111.111-11" || cpf === "222.222.222-22" || cpf === "333.333.333-33" || cpf === "444.444.444-44" || cpf === "555.555.555-55" || cpf === "666.666.666-66" || cpf === "777.777.777-77" || cpf === "888.888.888-88" || cpf === "999.999.999-99") {
      return false;
    }
    else {
      let numerosCPF = cpf.split(".").join("");
      numerosCPF = numerosCPF.split("-").join("");
      let soma = 0;
      let indice = 0;
      let resto = 0;
      let digitoVerificado;

      if (numerosCPF.length == 11) {
        for (let i = 10; i > 1; i--) {
          soma += parseInt(numerosCPF.charAt(indice) + "", 10) * i;
          indice++;
        }
        resto = 11 - (soma % 11);
        if (resto == 10 || resto == 11) {
          digitoVerificado = 0;
        } else {
          digitoVerificado = resto;
        }
        if (digitoVerificado == parseInt("" + numerosCPF.charAt(9), 10)) {
          indice = 0;
          soma = 0;
          resto = 0;
          for (let i = 11; i > 1; i--) {
            soma += parseInt(numerosCPF.charAt(indice) + "", 10) * i;
            indice++;
          }
          resto = 11 - (soma % 11);
          if (resto == 10 || resto == 11) {
            digitoVerificado = 0;
          } else {
            digitoVerificado = resto;
          }
          if (digitoVerificado == parseInt("" + numerosCPF.charAt(10), 10)) {
            return true;
          } else {
            return false;
          }
        } else {
          return false;
        }
      } else
        return false;
    }
  }

}
