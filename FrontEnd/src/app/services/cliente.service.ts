import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cliente } from '../shared/models/cliente';
//import { ResponsePageble } from '../shared/models/responsePageable.model';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {


  private readonly url = 'http://localhost:8080/clientes/';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private http: HttpClient) { }


  listarClientes() {
    return this.http.get<Cliente[]>(this.url + 'pageable');
  }

  listarClientesPag(page : string) {
    return this.http.get<Cliente[]>(this.url + 'pageable?page=' + page + '&size=10');
  }

  deletarCliente(id: String): Observable<any>{
    return this.http.delete(this.url + id);
  }

  salvarCliente(cliente: Cliente): Observable<any> {
    return this.http.post(this.url, cliente, {responseType: 'text'});
  }

  getCliente(id: String): Observable<any> {
    return this.http.get(this.url + id);
  }

  editarCliente(id: string, cliente: Cliente): Observable<any> {
    return this.http.put(this.url + id, cliente);
  }

  getTotalPaginas() : Observable<any>{
    return this.http.get(this.url + "totaldepaginas");
  }
}
