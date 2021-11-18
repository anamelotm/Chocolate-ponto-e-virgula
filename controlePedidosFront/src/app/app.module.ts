import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { ToastrModule } from 'ngx-toastr';

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
import { PedidoDetalharComponent } from './Empresa/pedido-detalhar/pedido-detalhar.component';
import {MatDialogModule} from '@angular/material/dialog';
import { CarrinhoDialogComponent } from './views/home/carrinho-dialog/carrinho-dialog.component';
import { CarrinhoItemComponent } from './views/home/carrinho-item/carrinho-item.component';
import { ItemProdutoComponent } from './views/home/item-produto/item-produto.component';
import { CarrinhoComponent } from './Cliente/carrinho/carrinho.component';

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
    PedidoDetalharComponent,
    CarrinhoDialogComponent,
    CarrinhoItemComponent,
    ItemProdutoComponent,
    CarrinhoComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    ToastrModule.forRoot(),
    MatDialogModule
    ],

  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [CarrinhoDialogComponent]
})
export class AppModule { }
