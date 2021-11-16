import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';
import { Produto } from '../shared/models/produto';

@Injectable({
  providedIn: 'root'
})
export class MessengerService {

  subject = new Subject();

  constructor() { }

  sendMsg(produto: Produto){
    this.subject.next(produto); //Triggering an event

  }

  getMsg(): Observable<any>{
    return this.subject.asObservable();
  }
}
