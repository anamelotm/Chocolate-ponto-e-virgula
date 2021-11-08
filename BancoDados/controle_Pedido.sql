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

-- alteração das tabelas e inserção das FK's

ALTER TABLE Item_Pedido add constraint fk_itemP_pedido FOREIGN KEY (codigo_pedido) REFERENCES pedido(codigo);
ALTER TABLE Item_Pedido add constraint fk_itemP_produto FOREIGN KEY (codigo_produto) REFERENCES produto(codigo);
ALTER TABLE Pedido add constraint fk_pedido_cliente FOREIGN KEY (codigo_cliente) REFERENCES cliente(codigo);

-- inserção de produtos

INSERT INTO produto (descricao_Produto, unidade_Medida , valor_Unitario , status) VALUES('Trufa de doce de leite', 'gr', 3.50, true);
INSERT INTO produto (descricao_Produto, unidade_Medida , valor_Unitario , status) VALUES('Barra de chocolate ao leite', 'gr', 22.90, true), 
('Pepitas com Açucar Mascavo', 'gr', 47.90, true);

-- alteracao da tabela produto - insercao de url_foto e peso

alter table produto add column url_Foto varchar (255) not null;
alter table produto add column Peso double (3,2);
alter table produto add column data_Fabricação date not null;
alter table produto add column data_Validade date not null;

-- correcao

ALTER TABLE produto CHANGE data_Fabricação data_Fabricacao date not null;

-- formatação das datas

SELECT DATE_FORMAT(data_Fabricacao, "%d %M %Y") FROM produto;
SELECT DATE_FORMAT(data_Validade, "%d %M %Y") FROM produto;

-- atualização dos produtos

UPDATE produto SET url_Foto = 'https://e7.pngegg.com/pngimages/372/321/png-clipart-chocolate-truffle-gaufrette-chocolate-truffle-chocolate.png', data_Fabricacao = '2021-11-08', data_Validade = '2024-11-08' WHERE Codigo = 1;


-- insercao de pedidos

insert into pedido (data_Pedido, Codigo_cliente, endereco_Entrega, Situacao, valor_Total, quantidade_Total, percentual_Desconto) values ('2021-11-08', 1, ), (), ();
