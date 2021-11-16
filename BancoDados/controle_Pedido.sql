drop schema controlepedidos;
create schema controlepedidos;
use controlepedidos;

create table cliente (
	codigo 				int 		not null auto_increment primary key,
	tipo				varchar(8) not null,
	documento			varchar(18) not null,
	nome				varchar(100) not null
);

create table produto (
	codigo 				int 		not null auto_increment primary key,
	nome 				varchar(100) not null,
	descricao 			text,
	unidade_medida 		varchar (2) not null,
	valor_unitario 		double (4,2) not null,
	status 				boolean 	not null,
	url_fotos			varchar(255) not null,
	peso				double(5,2) not null,
	data_fabricacao		date not null,
	data_validade		date not null,
	quantidade_estoque	int not null
);

create table pedido(
	codigo 				int not null auto_increment primary key,
	codigo_cliente 		int not null, -- FK da coluna codigo tabela cliente
	endereco_entrega 	varchar(150) not null,
	data_pedido			date not null,
	aberto 				boolean not null,
	valor_total			double(8,2) not null,
	quantidade_total	int not null,
	percentual_desconto	int
	
);

create table item_Pedido(
	codigo 				int not null auto_increment primary key,
	codigo_pedido		int not null,  -- FK da coluna codigo tabela pedido
	codigo_produto		int not null,  -- FK da coluna codigo tabela produto
	quantidade			int not null,
	valorTotal			double(5,2) not null
);

-- alteração das tabelas e inserção das FK's

ALTER TABLE item_Pedido add constraint fk_itemP_pedido FOREIGN KEY (codigo_pedido) REFERENCES pedido(codigo) on delete cascade;
ALTER TABLE item_Pedido add constraint fk_itemP_produto FOREIGN KEY (codigo_produto) REFERENCES produto(codigo) on delete cascade;
ALTER TABLE pedido add constraint fk_pedido_cliente FOREIGN KEY (codigo_cliente) REFERENCES cliente(codigo) on delete cascade;

desc cliente;
desc itemPedido;
desc pedido;
desc produto;

-- inserção de produtos

INSERT INTO produto (nome, unidade_medida , valor_unitario , status, url_fotos, peso, data_fabricacao, data_validade, quantidade_estoque) 
VALUES('Trufa de doce de leite', 'gr', 3.50, true, 'https://e7.pngegg.com/pngimages/372/321/png-clipart-chocolate-truffle-gaufrette-chocolate-truffle-chocolate.png', 11, '2021-11-08', '2024-11-08', 12);
INSERT INTO produto (nome, unidade_medida , valor_unitario , status, url_fotos, peso, data_fabricacao, data_validade, quantidade_estoque) 
VALUES('Barra de chocolate ao leite', 'gr', 22.90, true, 'https://e7.pngegg.com/pngimages/372/321/png-clipart-chocolate-truffle-gaufrette-chocolate-truffle-chocolate.png', 250, '2021-11-08', '2024-11-08', 20); 
INSERT INTO produto (nome, unidade_medida , valor_unitario , status, url_fotos, peso, data_fabricacao, data_validade, quantidade_estoque)
VALUES('Pepitas com Açucar Mascavo', 'gr', 47.90, true, 'https://e7.pngegg.com/pngimages/372/321/png-clipart-chocolate-truffle-gaufrette-chocolate-truffle-chocolate.png', 100, '2021-11-08', '2024-11-08', 22);

select * from produto;
=
-- insercao de cliente

insert into cliente (Tipo, Documento, Nome) values ('Física', '187.312.848-76', 'Manoel Theo Victor da Costa');
insert into cliente (Tipo, Documento, Nome) values ('Física', '241.712.021-67', 'Isabella Maitê Simone Barros');
insert into cliente (Tipo, Documento, Nome) values ('Jurídica', '13.109.836/0001-70', 'Nair e Brenda Publicidade e Propaganda ME');

select * from cliente;

-- insercao de pedido

insert into pedido (data_pedido, codigo_cliente, endereco_entrega, aberto, valor_total, quantidade_total, percentual_desconto) 
values ('2021-11-08', 1, 'Rua Capitão João Urias, 984, Centro, Águas da Prata/SP, 13890-972', true, 35.00, 10, 5);
insert into pedido (data_pedido, codigo_cliente, endereco_entrega, aberto, valor_total, quantidade_total, percentual_desconto) 
values ('2021-11-08', 2, 'Avenida João F. Abreu, 180, Setor Central, Abreulândia/TO, 77693-970', true, 45.80, 2, 5);
insert into pedido (data_pedido, codigo_cliente, endereco_entrega, aberto, valor_total, quantidade_total, percentual_desconto)
values ('2021-11-08', 3, 'Travessa Nossa Senhora da Aparecida, 599, Getúlio Vargas, Barra Mansa/RJ, 27325-530', true, 479.00, 10, 5);

-- insercao de item pedido

insert into item_Pedido (quantidade, valorTotal, codigo_pedido, codigo_produto) values (10, 33.25, 1, 1);
insert into item_Pedido (quantidade, valorTotal, codigo_pedido, codigo_produto) values (2, 43.51, 2, 2);
insert into item_Pedido (quantidade, valorTotal, codigo_pedido, codigo_produto) values (10, 455.05, 3, 3);


-- atualização do item pedido

update produto set quantidade_estoque=quantidade_estoque -10 where codigo =1;
update produto set quantidade_estoque=quantidade_estoque -2 where codigo =2;
update produto set quantidade_estoque=quantidade_estoque -10 where codigo =3;


select * from itemPedido;
select * from pedido;