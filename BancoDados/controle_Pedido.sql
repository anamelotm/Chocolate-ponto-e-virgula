create schema controlepedidos;
use controlepedidos;

create table cliente (
    codigo                 int         not null auto_increment primary key,
    tipo                varchar(8) not null,
    documento            varchar(18) not null,
    nome                varchar(100) not null
);

create table produto (
    codigo                 int         not null auto_increment primary key,
    nome                 varchar(100) not null,
    descricao             text,
    unidadeMedida         varchar (2) not null,
    valorUnitario         double (4,2) not null,
    status                 boolean     not null,
    urlFotos            varchar(255) not null,
    peso                double(5,2) not null,
    dataFabricacao        date not null,
    dataValidade        date not null,
    quantidadeEstoque    int not null
);
create table pedido(
    codigo                 int not null auto_increment primary key,
    codigoCliente         int not null, -- FK da coluna codigo tabela cliente
    enderecoEntrega     varchar(150) not null,
    dataPedido            date not null,
    aberto                 boolean not null,
    valorTotal            double(8,2) not null,
    quantidadeTotal    int not null,
    percentualDesconto    int
    
);
create table itemPedido(
    codigo                 int not null auto_increment primary key,
    codigoPedido        int not null,  -- FK da coluna codigo tabela pedido
    codigoProduto        int not null,  -- FK da coluna codigo tabela produto
    quantidade            int not null,
    valorTotal            double(5,2) not null
);

-- alteração das tabelas e inserção das FK's

ALTER TABLE itemPedido add constraint fk_itemP_pedido FOREIGN KEY (codigoPedido) REFERENCES pedido(codigo) on delete cascade;
ALTER TABLE itemPedido add constraint fk_itemP_produto FOREIGN KEY (codigoProduto) REFERENCES produto(codigo) on delete cascade;
ALTER TABLE pedido add constraint fk_pedido_cliente FOREIGN KEY (codigoCliente) REFERENCES cliente(codigo) on delete cascade;

desc cliente;
desc itemPedido;
desc pedido;
desc produto;

-- inserção de produtos

INSERT INTO produto (nome, unidadeMedida , valorUnitario , status, urlFotos, peso, dataFabricacao, dataValidade, quantidadeEstoque) 
VALUES('Trufa de doce de leite', 'gr', 3.50, true, 'https://e7.pngegg.com/pngimages/372/321/png-clipart-chocolate-truffle-gaufrette-chocolate-truffle-chocolate.png', 11, '2021-11-08', '2024-11-08', 12);
INSERT INTO produto (nome, unidadeMedida , valorUnitario , status, urlFotos, peso, dataFabricacao, dataValidade, quantidadeEstoque) 
VALUES('Barra de chocolate ao leite', 'gr', 22.90, true, 'https://e7.pngegg.com/pngimages/372/321/png-clipart-chocolate-truffle-gaufrette-chocolate-truffle-chocolate.png', 250, '2021-11-08', '2024-11-08', 20); 
INSERT INTO produto (nome, unidadeMedida , valorUnitario , status, urlFotos, peso, dataFabricacao, dataValidade, quantidadeEstoque) 
VALUES('Pepitas com Açucar Mascavo', 'gr', 47.90, true, 'https://e7.pngegg.com/pngimages/372/321/png-clipart-chocolate-truffle-gaufrette-chocolate-truffle-chocolate.png', 100, '2021-11-08', '2024-11-08', 22);

select * from produto;

-- formatação das datas

SELECT DATE_FORMAT(dataFabricacao, "%d %M %Y") FROM produto;
SELECT DATE_FORMAT(dataValidade, "%d %M %Y") FROM produto;
=
-- insercao de cliente

insert into cliente (Tipo, Documento, Nome) values ('Física', '187.312.848-76', 'Manoel Theo Victor da Costa');
insert into cliente (Tipo, Documento, Nome) values ('Física', '241.712.021-67', 'Isabella Maitê Simone Barros');
insert into cliente (Tipo, Documento, Nome) values ('Jurídica', '13.109.836/0001-70', 'Nair e Brenda Publicidade e Propaganda ME');

select * from cliente;

-- insercao de pedido

insert into pedido (datapedido, Codigocliente, enderecoEntrega, aberto, valorTotal, quantidadeTotal, percentualDesconto) 
values ('2021-11-08', 1, 'Rua Capitão João Urias, 984, Centro, Águas da Prata/SP, 13890-972', true, 35.00, 10, 5);
insert into pedido (datapedido, Codigocliente, enderecoEntrega, aberto, valorTotal, quantidadeTotal, percentualDesconto) 
values ('2021-11-08', 2, 'Avenida João F. Abreu, 180, Setor Central, Abreulândia/TO, 77693-970', true, 45.80, 2, 5);
insert into pedido (datapedido, Codigocliente, enderecoEntrega, aberto, valorTotal, quantidadeTotal, percentualDesconto) 
values ('2021-11-08', 3, 'Travessa Nossa Senhora da Aparecida, 599, Getúlio Vargas, Barra Mansa/RJ, 27325-530', true, 479.00, 10, 5);

-- insercao de item pedido

insert into itemPedido (quantidade, valorTotal, codigoPedido, codigoProduto) values (10, 33.25, 1, 1);
insert into itemPedido (quantidade, valorTotal, codigoPedido, codigoProduto) values (2, 43.51, 2, 2);
insert into itemPedido (quantidade, valorTotal, codigoPedido, codigoProduto) values (10, 455.05, 3, 3);

-- atualização do item pedido

update produto set quantidadeEstoque=quantidadeEstoque -10 where codigo = 1;
update produto set quantidadeEstoque=quantidadeEstoque -2 where codigo = 2;
update produto set quantidadeEstoque=quantidadeEstoque -10 where codigo = 3;


select * from itemPedido;
select * from pedido;