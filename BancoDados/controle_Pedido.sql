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

ALTER TABLE produto modify column Peso double(4,2);

-- correcao da tabela produto

ALTER TABLE produto CHANGE data_Fabricação data_Fabricacao date not null;

-- formatação das datas

SELECT DATE_FORMAT(data_Fabricacao, "%d %M %Y") FROM produto;
SELECT DATE_FORMAT(data_Validade, "%d %M %Y") FROM produto;

-- atualização dos produtos

UPDATE produto SET url_Foto = 'https://e7.pngegg.com/pngimages/372/321/png-clipart-chocolate-truffle-gaufrette-chocolate-truffle-chocolate.png', data_Fabricacao = '2021-11-08', data_Validade = '2024-11-08' WHERE Codigo = 1;

-- insercao de cliente

insert into cliente (Tipo, Documento, Nome) values ('Física', '187.312.848-76', 'Manoel Theo Victor da Costa');
insert into cliente (Tipo, Documento, Nome) values ('Física', '241.712.021-67', 'Isabella Maitê Simone Barros');
insert into cliente (Tipo, Documento, Nome) values ('Jurídica', '13.109.836/0001-70', 'Nair e Brenda Publicidade e Propaganda ME');

-- alteracao de cliente

ALTER TABLE cliente modify column Documento varchar(20) not null;


-- insercao de pedidos

insert into pedido (data_Pedido, Codigo_cliente, endereco_Entrega, Situacao, valor_Total, quantidade_Total, percentual_Desconto) values ('2021-11-08', 1, ), (), ();

-- insercao de pedido

insert into pedido (data_pedido, Codigo_cliente, endereco_Entrega, Situacao, valor_Total, quantidade_Total, percentual_Desconto) 
values ('2021-11-08', 1, 'Rua Capitão João Urias, 984, Centro, Águas da Prata/SP, 13890-972', true, 35.00, 10, 5);
insert into pedido (data_pedido, Codigo_cliente, endereco_Entrega, Situacao, valor_Total, quantidade_Total, percentual_Desconto) 
values ('2021-11-08', 2, 'Avenida João F. Abreu, 180, Setor Central, Abreulândia/TO, 77693-970', true, 45.80, 2, 2);
insert into pedido (data_pedido, Codigo_cliente, endereco_Entrega, Situacao, valor_Total, quantidade_Total, percentual_Desconto) 
values ('2021-11-08', 3, 'Travessa Nossa Senhora da Aparecida, 599, Getúlio Vargas, Barra Mansa/RJ, 27325-530', true, 479.00, 10, 5);

-- insercao de item pedido

insert into item_pedido (Quantidade, Valor_Total, Codigo_Pedido, Codigo_Produto) values (10, 33.25, 1, 1);
insert into item_pedido (Quantidade, Valor_Total, Codigo_Pedido, Codigo_Produto) values (2, 44.88, 2, 2);
insert into item_pedido (Quantidade, Valor_Total, Codigo_Pedido, Codigo_Produto) values (10, 455.05, 4, 3);

-- alteração em item_pedido
ALTER TABLE item_pedido modify column valor_total double(5,2) not null;

select * from item_pedido ip ;
select * from pedido;
desc item_pedido ;
