drop schema controlepedidos;
create schema controlepedidos;
use controlepedidos;


create table cliente (
	id 				int 		not null auto_increment primary key,
	tipo				varchar(8) not null,
	documento			varchar(18) not null,
	nome				varchar(100) not null
);

create table produto (
	id 				int 		not null auto_increment primary key,
	nome 				varchar(100) not null,
	descricao 			text,
	unidade_medida 		varchar (2) not null,
	valor_unitario 		double (4,2) not null,
	status 				boolean 	not null,
	url_foto			varchar(255) not null,
	peso				double(5,2) not null,
	data_fabricacao		date not null,
	data_validade		date not null,
	quantidade_estoque	int not null
);

create table pedido(
	id 				int not null auto_increment primary key,
	id_cliente 		int, -- FK da coluna codigo tabela cliente
	endereco_entrega 	varchar(150),
	data_pedido			date not null,
	aberto 				boolean not null,
	valor_total			double(8,2) not null,
	quantidade_total	int not null,
	percentual_desconto	int
	
);

create table item_Pedido(
	id 				int not null auto_increment primary key,
	id_pedido		int not null,  -- FK da coluna codigo tabela pedido
	id_produto		int not null,  -- FK da coluna codigo tabela produto
	quantidade			int not null,
	valor_total			double(5,2) not null
);

-- alteração das tabelas e inserção das FK's

ALTER TABLE item_Pedido add constraint fk_itemP_pedido FOREIGN KEY (id_pedido) REFERENCES pedido(id) on delete cascade;
ALTER TABLE item_Pedido add constraint fk_itemP_produto FOREIGN KEY (id_produto) REFERENCES produto(id) on delete cascade;
ALTER TABLE pedido add constraint fk_pedido_cliente FOREIGN KEY (id_cliente) REFERENCES cliente(id) on delete cascade;

desc cliente;
desc itemPedido;
desc pedido;
desc produto;

-- inserção de produtos

INSERT INTO produto (nome, descricao, unidade_medida , valor_unitario , status, url_foto, peso, data_fabricacao, data_validade, quantidade_estoque) 
VALUES('Trufa de doce de leite', 'Artesanal, feito em fogão à lenha, sem conservantes e redução na adição de açúcar.', 'gr', 3.50, true, 'https://images.unsplash.com/photo-1582493255270-b3844e2a63c8?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1882&q=80', 11, '2021-11-08', '2024-11-08', 12);
INSERT INTO produto (nome, descricao, unidade_medida , valor_unitario , status, url_foto, peso, data_fabricacao, data_validade, quantidade_estoque) 
VALUES('Barra de chocolate ao leite', 'Esta barra foi produzida com a inclusão da fava de baunilha orgânica da variedade planifólia cultivada em ilhéus, no sul da Bahia pelo produtor Ângelo Figueiredo Tomás.', 'gr', 22.90, true, 'https://images.unsplash.com/photo-1584382213731-95e51d7cf4c3?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=810&q=80', 250, '2021-11-08', '2024-11-08', 20); 
INSERT INTO produto (nome, descricao, unidade_medida , valor_unitario , status, url_foto, peso, data_fabricacao, data_validade, quantidade_estoque)
VALUES('Pepitas com Açucar Mascavo', 'Irresistíveis amêndoas de cacau, torradas, caramelizadas e cobertas no mais puro chocolate Dengo 50% cacau e finalizadas com açúcar mascavo.', 'gr', 47.90, true, 'https://st3.depositphotos.com/13707056/16144/i/600/depositphotos_161441226-stock-photo-cocoa-nibs-in-spoon.jpg', 100, '2021-11-08', '2024-11-08', 22);

select * from produto;

-- insercao de cliente

insert into cliente (Tipo, Documento, Nome) values ('Física', '187.312.848-76', 'Manoel Theo Victor da Costa');
insert into cliente (Tipo, Documento, Nome) values ('Física', '241.712.021-67', 'Isabella Maitê Simone Barros');
insert into cliente (Tipo, Documento, Nome) values ('Jurídica', '13.109.836/0001-70', 'Nair e Brenda Publicidade e Propaganda ME');

select * from cliente;

-- insercao de pedido

insert into pedido (data_pedido, id_cliente, endereco_entrega, aberto, valor_total, quantidade_total, percentual_desconto) 
values ('2021-11-08', 1, 'Rua Capitão João Urias, 984, Centro, Águas da Prata/SP, 13890-972', true, 35.00, 10, 10);
insert into pedido (data_pedido, id_cliente, endereco_entrega, aberto, valor_total, quantidade_total, percentual_desconto) 
values ('2021-11-08', 2, 'Avenida João F. Abreu, 180, Setor Central, Abreulândia/TO, 77693-970', true, 45.80, 2, 10);
insert into pedido (data_pedido, id_cliente, endereco_entrega, aberto, valor_total, quantidade_total, percentual_desconto)
values ('2021-11-08', 3, 'Travessa Nossa Senhora da Aparecida, 599, Getúlio Vargas, Barra Mansa/RJ, 27325-530', true, 479.00, 10, 10);

-- insercao de item pedido

insert into item_Pedido (quantidade, valor_total, id_pedido, id_produto) values (10, 33.25, 1, 1);
insert into item_Pedido (quantidade, valor_total, id_pedido, id_produto) values (2, 43.51, 2, 2);
insert into item_Pedido (quantidade, valor_total, id_pedido, id_produto) values (10, 455.05, 3, 3);


-- atualização do item pedido

update produto set quantidade_estoque=quantidade_estoque -10 where id = 1;
update produto set quantidade_estoque=quantidade_estoque -2 where id = 2;
update produto set quantidade_estoque=quantidade_estoque -10 where id = 3;


select * from item_Pedido;
select * from pedido;

desc cliente;