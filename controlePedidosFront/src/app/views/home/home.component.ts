import { Component, OnInit } from '@angular/core';
import { CarrinhoService } from 'src/app/services/carrinho.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public totalItens: number = 0;

  constructor(private service: CarrinhoService) { }

  ngOnInit(): void {
    this.service.getProducts().subscribe(res => {
      this.totalItens = res.length;
    })
  }


}
