import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {Component} from '@angular/core';
import {MatExpansionModule} from '@angular/material/expansion';

import { ClienteCadastrarComponent } from './Cliente/cliente-cadastrar/cliente-cadastrar.component';
import { ClienteListarComponent } from './Empresa/cliente-listar/cliente-listar.component';
import { PedidosListarComponent } from './Empresa/pedidos-listar/pedidos-listar.component';
import { ProdutoCadastrarComponent } from './Empresa/produto-cadastrar/produto-cadastrar.component';
import { ProdutosListarComponent } from './Empresa/produtos-listar/produtos-listar.component';
import { FazerPedidoComponent } from './Cliente/fazer-pedido/fazer-pedido.component';

@NgModule({
  declarations: [
    AppComponent,
    ClienteCadastrarComponent,
    ClienteListarComponent,
    PedidosListarComponent,
    ProdutoCadastrarComponent,
    ProdutosListarComponent,
    FazerPedidoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule, 
    MatExpansionModule

  ],

  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
