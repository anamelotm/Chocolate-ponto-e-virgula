create schema controlePedidos;

use controlePedidos;

create table Produto (
	Codigo 				int 		not null auto_increment primary key,
	descricao_Produto 	varchar (100) not null,
	unidade_Medida 		varchar (2) not null,
	valor_Unitario 		double (4,2) not null,
	Status 				boolean 	not null
);

create table Pedido (
	Codigo  			int 		not null auto_increment primary key,
	data_Pedido 		DateTime 	not null,
	Codigo_cliente 		int 		not null,
	endereco_Entrega 	varchar (150),
	Situacao 			boolean 	not null,
	valor_Total 		double (8,2) not null,
	quantidade_Total 	int 		not null, 
	percentual_Desconto int
);

create table Item_Pedido(
	Codigo 				int 		not null auto_increment primary key,
	Quantidade 			int 		not null,
	Valor_Total 		double(4,2) not null,
	Codigo_Pedido 		int 		not null,
	Codigo_Produto 		int 		not null
);


create table Cliente (
	Codigo 				int 		not null auto_increment primary key,
	Tipo 				varchar (8) not null,
	Documento 			varchar(17) not null,
	Nome  				varchar (100) not null
);

desc produto;
desc pedido;
desc item_pedido;
desc cliente;

select * from produto;
select * from pedido;
select * from item_pedido;
select * from cliente;

ALTER TABLE Item_Pedido add constraint fk_itemP_pedido FOREIGN KEY (codigo_pedido) REFERENCES pedido(codigo);
ALTER TABLE Item_Pedido add constraint fk_itemP_produto FOREIGN KEY (codigo_produto) REFERENCES produto(codigo);
ALTER TABLE Pedido add constraint fk_pedido_cliente FOREIGN KEY (codigo_cliente) REFERENCES cliente(codigo);

