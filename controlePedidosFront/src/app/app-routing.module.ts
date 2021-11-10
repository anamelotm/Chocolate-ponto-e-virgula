import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClienteCadastrarComponent } from './Cliente/cliente-cadastrar/cliente-cadastrar.component';
import { FazerPedidoComponent } from './Cliente/fazer-pedido/fazer-pedido.component';
import { ClienteListarComponent } from './Empresa/cliente-listar/cliente-listar.component';
import { PedidosListarComponent } from './Empresa/pedidos-listar/pedidos-listar.component';
import { ProdutoCadastrarComponent } from './Empresa/produto-cadastrar/produto-cadastrar.component';
import { ProdutosListarComponent } from './Empresa/produtos-listar/produtos-listar.component';
import { HomeComponent } from './views/home/home.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'cliente-cadastrar', component: ClienteCadastrarComponent},
  {path: 'fazer-pedido', component: FazerPedidoComponent},
  {path: 'cliente-listar', component: ClienteListarComponent},
  {path: 'pedidos-listar', component: PedidosListarComponent},
  {path: 'produto-cadastrar', component: ProdutoCadastrarComponent},
  {path: 'produtos-listar', component: ProdutosListarComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
