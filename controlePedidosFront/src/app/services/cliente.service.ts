import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cliente } from '../shared/models/cliente';
import { ResponsePageble } from '../shared/models/responsePageable.model';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  //!!!atualizar o endereço!!!
  //url='http://localhost:4000/api/cliente';

  private readonly url = 'http://localhost:8080/clientes/';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private http: HttpClient) { }


  listarClientes(flag: String): Observable<ResponsePageble>{
    return this.http.get<ResponsePageble>(this.url + 'pageable?page=' + flag + '&size=10');
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
