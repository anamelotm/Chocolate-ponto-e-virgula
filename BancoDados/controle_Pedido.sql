drop schema controlepedidos;
create schema controlepedidos;
use controlepedidos;

/*!50503 SET character_set_client = utf8mb4 */;
create table cliente (
	id 				int 		not null auto_increment primary key,
	tipo				varchar(8) not null,
	documento			varchar(18) not null,
	nome				varchar(100) not null
);
/*!50503 SET character_set_client = utf8mb4 */;
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
/*!50503 SET character_set_client = utf8mb4 */;
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
/*!50503 SET character_set_client = utf8mb4 */;
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
select*from produto p ;
-- inserção de produtos

INSERT INTO produto (nome, descricao, unidade_medida , valor_unitario , status, url_foto, peso, data_fabricacao, data_validade, quantidade_estoque) 
VALUES('Trufa de doce de leite', 'Artesanal, feito em fogão à lenha, sem conservantes e redução na adição de açúcar.', 'gr', 3.50, true, 'https://images.unsplash.com/photo-1582493255270-b3844e2a63c8?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1882&q=80', 11, '2021-11-08', '2024-11-08', 32);
INSERT INTO produto (nome, descricao, unidade_medida , valor_unitario , status, url_foto, peso, data_fabricacao, data_validade, quantidade_estoque) 
VALUES('Barra de chocolate ao leite', 'Esta barra foi produzida com a inclusão da fava de baunilha orgânica da variedade planifólia cultivada em ilhéus, no sul da Bahia pelo produtor Ângelo Figueiredo Tomás.', 'gr', 22.90, true, 'https://images.unsplash.com/photo-1584382213731-95e51d7cf4c3?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=810&q=80', 250, '2021-11-08', '2024-11-08', 30); 
INSERT INTO produto (nome, descricao, unidade_medida , valor_unitario , status, url_foto, peso, data_fabricacao, data_validade, quantidade_estoque)
VALUES('Pepitas com Açucar Mascavo', 'Irresistíveis amêndoas de cacau, torradas, caramelizadas e cobertas no mais puro chocolate Dengo 50% cacau e finalizadas com açúcar mascavo.', 'gr', 47.90, true, 'https://st3.depositphotos.com/13707056/16144/i/600/depositphotos_161441226-stock-photo-cocoa-nibs-in-spoon.jpg', 100, '2021-11-08', '2024-11-08', 32);
INSERT INTO produto (nome, descricao, unidade_medida , valor_unitario , status, url_foto, peso, data_fabricacao, data_validade, quantidade_estoque)
VALUES('Língua de Gato', 'O sabor clássico do nosso delicioso chocolate ao leite em formato de Língua de Gato que conquista todos os apaixonados por chocolate.', 'gr', 49.90, true, 'https://proxy.thumb321.com.br/img-432221340b032cdf.png', 150, '2021-11-24', '2024-11-08', 40);
INSERT INTO produto (nome, descricao, unidade_medida , valor_unitario , status, url_foto, peso, data_fabricacao, data_validade, quantidade_estoque)
VALUES('Panettone Língua de Gato', 'Panettone com gotas de chocolate ao leite e recheio de chocolate ao leite tradicional Língua de Gato, coberto com chocolate ao leite e decorado com língua de gato.', 'gr', 99.90, true, 'https://www.supermercadorazia.com.br/storage/fotos_produtos/539/1e16b7a3bccacebb16bb5a13f742f5f6.png', 900, '2021-11-23', '2024-11-08', 35);
INSERT INTO produto (nome, descricao, unidade_medida , valor_unitario , status, url_foto, peso, data_fabricacao, data_validade, quantidade_estoque)
VALUES('Kit bombons ao Leite C/ Recheio Cherry', 'Bombons Ao Leite com Recheio Cherry. Feito com o nosso irresistível chocolate ao leite e recheado com o clássico Cherry Brandy. ', 'gr', 24.90, true, 'https://chocolatesgenebra.com.br/wp-content/uploads/2020/06/cherry-1-1.jpg', 90, '2021-11-24', '2024-11-08', 45);
INSERT INTO produto (nome, descricao, unidade_medida , valor_unitario , status, url_foto, peso, data_fabricacao, data_validade, quantidade_estoque)
VALUES('Alfajor Ganache', 'Com recheio de ganache e cobertura de chocolate ao leite, ele promete te surpreender e até virar um dos seus doces preferidos!', 'gr', 59.90, true, 'https://receitinhas.s3-sa-east-1.amazonaws.com/wp-content/uploads/2017/01/alfajor_150.jpeg-848x477.png', 300, '2021-11-23', '2024-11-08', 30);
INSERT INTO produto (nome, descricao, unidade_medida , valor_unitario , status, url_foto, peso, data_fabricacao, data_validade, quantidade_estoque)
VALUES('Tablete 80%', 'Este é o Tablete de Chocolate 80% Cacau. Perfeito para quem gosta de chocolate amargo! ', 'gr', 24.90, true, 'https://runnersworld.com.br/wp-content/uploads/sites/4/2016/07/Chocolate1.png', 100, '2021-11-24', '2024-11-08', 40);
INSERT INTO produto (nome, descricao, unidade_medida , valor_unitario , status, url_foto, peso, data_fabricacao, data_validade, quantidade_estoque)
VALUES('Tablete 70%', 'Este é o Tablete de Chocolate 70% Cacau. Perfeito para quem gosta de chocolate amargo! ', 'gr', 24.90, true, 'https://runnersworld.com.br/wp-content/uploads/sites/4/2016/07/Chocolate1.png', 100, '2021-11-23', '2024-11-08', 35);
INSERT INTO produto (nome, descricao, unidade_medida , valor_unitario , status, url_foto, peso, data_fabricacao, data_validade, quantidade_estoque)
VALUES('Tablete 60%', 'Este é o Tablete de Chocolate 60% Cacau. Perfeito para quem gosta de chocolate amargo! ', 'gr', 24.90, true, 'https://runnersworld.com.br/wp-content/uploads/sites/4/2016/07/Chocolate1.png', 100, '2021-11-23', '2024-11-08', 45);
INSERT INTO produto (nome, descricao, unidade_medida , valor_unitario , status, url_foto, peso, data_fabricacao, data_validade, quantidade_estoque)
VALUES('Tablete 50%', 'Este é o Tablete de Chocolate 50% Cacau. Perfeito para quem gosta de chocolate amargo! ', 'gr', 24.90, true, 'https://runnersworld.com.br/wp-content/uploads/sites/4/2016/07/Chocolate1.png', 100, '2021-11-23', '2024-11-08', 30);
INSERT INTO produto (nome, descricao, unidade_medida , valor_unitario , status, url_foto, peso, data_fabricacao, data_validade, quantidade_estoque)
VALUES('Tablete Branco', 'Este é o Tablete Branco. Feito especialmente para quem ama chocolate branco.', 'gr', 22.90, true, 'https://s.cornershopapp.com/product-images/2834069.png?versionId=m_fklddJGIVR9YC8xiRrSQTF_NaihSRc', 100, '2021-11-24', '2024-11-08', 40);
INSERT INTO produto (nome, descricao, unidade_medida , valor_unitario , status, url_foto, peso, data_fabricacao, data_validade, quantidade_estoque)
VALUES('Kit c/ 3 Tabletes Branco', 'Este é o Tablete Branco. Feito especialmente para quem ama chocolate branco.', 'gr', 29.90, true, 'https://s.cornershopapp.com/product-images/2834069.png?versionId=m_fklddJGIVR9YC8xiRrSQTF_NaihSRc', 40, '2021-11-23', '2024-11-08', 50);
INSERT INTO produto (nome, descricao, unidade_medida , valor_unitario , status, url_foto, peso, data_fabricacao, data_validade, quantidade_estoque)
VALUES('Nuts', 'Perfeito para quem gosta de chocolate ao leite, mas busca por opções sem glúten, zero lactose, zero adição de açúcares e sem adoçantes artificiais.', 'gr', 32.90, true, 'https://5.imimg.com/data5/SELLER/Default/2020/11/AE/OA/WP/81680167/chocolate-coated-almonds-500x500.jpg', 85, '2021-11-23', '2024-11-08', 40);
INSERT INTO produto (nome, descricao, unidade_medida , valor_unitario , status, url_foto, peso, data_fabricacao, data_validade, quantidade_estoque)
VALUES('Bombons Avelã', '08 Bombons de chocolate ao leite com recheio cremoso de avelã para dietas com restrição de lactose.', 'gr', 59.90, true, 'https://cdn.awsli.com.br/1554/1554716/produto/64839242/c7d15a371e.jpg', 160, '2021-11-24', '2024-11-08', 45);


select * from produto;
desc produto ;
-- insercao de cliente

insert into cliente (Tipo, Documento, Nome) values ('Física', '187.312.848-76', 'Manoel Theo Victor da Costa');
insert into cliente (Tipo, Documento, Nome) values ('Física', '241.712.021-67', 'Isabella Maitê Simone Barros');
insert into cliente (Tipo, Documento, Nome) values ('Jurídica', '13.109.836/0001-70', 'Nair e Brenda Publicidade e Propaganda ME');
insert into cliente (Tipo, Documento, Nome) values ('Física', '765.843.977-00', 'Antonella Milena Barros');
insert into cliente (Tipo, Documento, Nome) values ('Física', '878.692.796-50', 'Renan Joaquim Gabriel da Conceição');
insert into cliente (Tipo, Documento, Nome) values ('Física', '386.190.771-20', 'Vera Eliane Cecília Cardoso');
insert into cliente (Tipo, Documento, Nome) values ('Física', '738.442.851-30', 'Erick Eduardo Assis');
insert into cliente (Tipo, Documento, Nome) values ('Física', '446.893.814-53', 'Letícia Renata Luiza Pinto');
insert into cliente (Tipo, Documento, Nome) values ('Física', '445.993.157-53', 'Vinicius Giovanni Sérgio Rodrigues');
insert into cliente (Tipo, Documento, Nome) values ('Física', '290.161.588-04', 'Caroline Silvana Milena Silva');
insert into cliente (Tipo, Documento, Nome) values ('Física', '031.400.774-16', 'Márcia Isabella Freitas');
insert into cliente (Tipo, Documento, Nome) values ('Física', '956.601.509-77', 'Ryan Vinicius Lorenzo Porto');
insert into cliente (Tipo, Documento, Nome) values ('Física', '382.250.810-13', 'Agatha Antonella Silveira');
insert into cliente (Tipo, Documento, Nome) values ('Física', '754.858.084-33', 'Luan Francisco Oliver Carvalho');
insert into cliente (Tipo, Documento, Nome) values ('Física', '793.038.096-37', 'Cauê Nelson José Vieira');
insert into cliente (Tipo, Documento, Nome) values ('Física', '483.847.514-47', 'Alexandre Henry André de Paula');
insert into cliente (Tipo, Documento, Nome) values ('Física', '602.940.739-22', 'Noah Igor Roberto da Cunha');


select * from cliente;
select*from pedido p ;
-- insercao de pedido

insert into pedido (data_pedido, id_cliente, endereco_entrega, aberto, valor_total, quantidade_total, percentual_desconto) 
values ('2021-11-08', 1, 'Rua Capitão João Urias, 984, Centro, Águas da Prata/SP, 13890-972', true, 35.00, 10, 10);
insert into pedido (data_pedido, id_cliente, endereco_entrega, aberto, valor_total, quantidade_total, percentual_desconto) 
values ('2021-11-08', 2, 'Avenida João F. Abreu, 180, Setor Central, Abreulândia/TO, 77693-970', true, 45.80, 2, 10);
insert into pedido (data_pedido, id_cliente, endereco_entrega, aberto, valor_total, quantidade_total, percentual_desconto)
values ('2021-11-08', 3, 'Travessa Nossa Senhora da Aparecida, 599, Getúlio Vargas, Barra Mansa/RJ, 27325-530', true, 479.00, 10, 10);
insert into pedido (data_pedido, id_cliente, endereco_entrega, aberto, valor_total, quantidade_total, percentual_desconto)
values ('2021-11-24', 4, 'Rua Andrade Bezerra, 836, Estação Nova, Camaragibe/PE, 54774-200', true, 499.00, 10, 10);
insert into pedido (data_pedido, id_cliente, endereco_entrega, aberto, valor_total, quantidade_total, percentual_desconto)
values ('2021-11-24', 5, 'Rua Q, 625, Santo Antonio, Carpina/PE, 55814-110', true, 999.00, 10, 10);
insert into pedido (data_pedido, id_cliente, endereco_entrega, aberto, valor_total, quantidade_total, percentual_desconto)
values ('2021-11-24', 6, 'Rua Carbonato, 762, Vila São Francisco de Assis, Telêmaco Borba/PR, 84264-610', true, 249.00, 10, 10);
insert into pedido (data_pedido, id_cliente, endereco_entrega, aberto, valor_total, quantidade_total, percentual_desconto)
values ('2021-11-24', 7, 'Rua Seis, 887, Ponte dos Carvalhos, Cabo de Santo Agostinho/PE, 54580-538', true, 599.00, 10, 10);
insert into pedido (data_pedido, id_cliente, endereco_entrega, aberto, valor_total, quantidade_total, percentual_desconto)
values ('2021-11-24', 8, 'Rua Paulino Gomes, 343, Petrópolis, Manaus/AM, 69079-360', true, 249.00, 10, 10);
insert into pedido (data_pedido, id_cliente, endereco_entrega, aberto, valor_total, quantidade_total, percentual_desconto)
values ('2021-11-24', 9, 'Rua Pedro Procópio de Oliveira, 394, Jardim Barcelona, Londrina/PR, 86073-348', true, 249.00, 10, 10);
insert into pedido (data_pedido, id_cliente, endereco_entrega, aberto, valor_total, quantidade_total, percentual_desconto)
values ('2021-11-24', 10, 'Avenida Quinta, 359, Cabralzinho, Macapá/AP, 68906-859', true, 249.00, 10, 10);
insert into pedido (data_pedido, id_cliente, endereco_entrega, aberto, valor_total, quantidade_total, percentual_desconto)
values ('2021-11-24', 11, 'Rua Antônio Alves Loures, 744, Morro Alto, Guarapuava/PR, 85067-340', true, 249.00, 10, 10);
insert into pedido (data_pedido, id_cliente, endereco_entrega, aberto, valor_total, quantidade_total, percentual_desconto)
values ('2021-11-24', 12, '1ª Travessa Maria das Dores Cumaru, 726, Frei Damião, Belo Jardim/PE, 27325-530', true, 229.00, 10, 10);
insert into pedido (data_pedido, id_cliente, endereco_entrega, aberto, valor_total, quantidade_total, percentual_desconto)
values ('2021-11-24', 13, 'Travessa São Jorge, 919, Santos Dumont, Aracaju/SE, 49087-550', true, 299.00, 10, 10);
insert into pedido (data_pedido, id_cliente, endereco_entrega, aberto, valor_total, quantidade_total, percentual_desconto)
values ('2021-11-24', 14, 'Rodovia AC-10, 357, Alto Alegre, Rio Branco/AC, 69921-230', true, 329.00, 10, 10);
insert into pedido (data_pedido, id_cliente, endereco_entrega, aberto, valor_total, quantidade_total, percentual_desconto)
values ('2021-11-24', 15, 'Avenida Professor Luiz Ignácio Anhaia Mello, 308, Vila Ema, São Paulo/SP, 03295-100', true, 599.00, 10, 10);


select * from pedido;
select *from item_pedido ip ;
-- insercao de item pedido

insert into item_Pedido (quantidade, valor_total, id_pedido, id_produto) values (10, 35, 1, 1);
insert into item_Pedido (quantidade, valor_total, id_pedido, id_produto) values (2, 45.8, 2, 2);
insert into item_Pedido (quantidade, valor_total, id_pedido, id_produto) values (10, 479, 3, 3);
insert into item_Pedido (quantidade, valor_total, id_pedido, id_produto) values (10, 499, 4, 4);
insert into item_Pedido (quantidade, valor_total, id_pedido, id_produto) values (10, 999, 5, 5);
insert into item_Pedido (quantidade, valor_total, id_pedido, id_produto) values (10, 249, 6, 6);
insert into item_Pedido (quantidade, valor_total, id_pedido, id_produto) values (10, 599, 7, 7);
insert into item_Pedido (quantidade, valor_total, id_pedido, id_produto) values (10, 249, 8, 8);
insert into item_Pedido (quantidade, valor_total, id_pedido, id_produto) values (10, 249, 9, 9);
insert into item_Pedido (quantidade, valor_total, id_pedido, id_produto) values (10, 249, 10, 10);
insert into item_Pedido (quantidade, valor_total, id_pedido, id_produto) values (10, 249, 11, 11);
insert into item_Pedido (quantidade, valor_total, id_pedido, id_produto) values (10, 229, 12, 12);
insert into item_Pedido (quantidade, valor_total, id_pedido, id_produto) values (10, 299, 13, 13);
insert into item_Pedido (quantidade, valor_total, id_pedido, id_produto) values (10, 329, 14, 14);
insert into item_Pedido (quantidade, valor_total, id_pedido, id_produto) values (10, 599, 15, 15);


select * from item_pedido ip ;

-- atualização do item pedido

update produto set quantidade_estoque=quantidade_estoque -10 where id = 1;
update produto set quantidade_estoque=quantidade_estoque -2 where id = 2;
update produto set quantidade_estoque=quantidade_estoque -10 where id = 3;
update produto set quantidade_estoque=quantidade_estoque -10 where id = 4;
update produto set quantidade_estoque=quantidade_estoque -10 where id = 5;
update produto set quantidade_estoque=quantidade_estoque -10 where id = 6;
update produto set quantidade_estoque=quantidade_estoque -10 where id = 7;
update produto set quantidade_estoque=quantidade_estoque -10 where id = 8;
update produto set quantidade_estoque=quantidade_estoque -10 where id = 9;
update produto set quantidade_estoque=quantidade_estoque -10 where id = 10;
update produto set quantidade_estoque=quantidade_estoque -10 where id = 11;
update produto set quantidade_estoque=quantidade_estoque -10 where id = 12;
update produto set quantidade_estoque=quantidade_estoque -10 where id = 13;
update produto set quantidade_estoque=quantidade_estoque -10 where id = 14;
update produto set quantidade_estoque=quantidade_estoque -10 where id = 15;

select *from produto p ;