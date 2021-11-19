import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cliente } from '../shared/models/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  //!!!atualizar o endereço!!!
  //url='http://localhost:4000/api/cliente';

  private readonly url = 'http://localhost:8080/clientes/';

  constructor(private http: HttpClient) { }


  listarClientes(){
    return this.http.get<Cliente[]>(this.url);
  }

  deletarCliente(id: String): Observable<any>{
    return this.http.delete(this.url + id);
  }

  salvarCliente(cliente: Cliente): Observable<any> {
    return this.http.post(this.url, cliente);
  }

  getCliente(id: String): Observable<any> {
    return this.http.get(this.url + id);
  }

  editarCliente(id: string, cliente: Cliente): Observable<any> {
    return this.http.put(this.url + id, cliente);
  }
}
