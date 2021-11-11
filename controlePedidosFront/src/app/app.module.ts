import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClienteCadastrarComponent } from './Cliente/cliente-cadastrar/cliente-cadastrar.component';
import { FazerPedidoComponent } from './Cliente/fazer-pedido/fazer-pedido.component';
import { ClienteListarComponent } from './Empresa/cliente-listar/cliente-listar.component';
import { PedidosListarComponent } from './Empresa/pedidos-listar/pedidos-listar.component';
import { ProdutoCadastrarComponent } from './Empresa/produto-cadastrar/produto-cadastrar.component';
import { ProdutosListarComponent } from './Empresa/produtos-listar/produtos-listar.component';
import { HomeComponent } from './views/home/home.component';
import { FormsModule } from '@angular/forms';




@NgModule({
  declarations: [
    AppComponent,
    ClienteCadastrarComponent,
    ClienteListarComponent,
    PedidosListarComponent,
    ProdutoCadastrarComponent,
    ProdutosListarComponent,
    FazerPedidoComponent,
    HomeComponent,
 
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule
    ],

  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
