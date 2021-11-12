import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cliente } from '../shared/models/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  //!!!atualizar o endereço!!!
  url='http://localhost:4000/api/cliente';

  private readonly urlCliente = 'http://localhost:3000/clientes';

  constructor(private http: HttpClient) { }

  getCliente(): Observable<any> {
    return this.http.get(this.url);
  }

  listarClientes(){
    return this.http.get<Cliente[]>(this.urlCliente);
  }

}
