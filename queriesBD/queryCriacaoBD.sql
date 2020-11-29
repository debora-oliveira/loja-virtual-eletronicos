create database lojaVirtualEletronico;
use lojaVirtualEletronico;

create table usuario (
	id int auto_increment,
    email varchar(100),
    senha varchar(100),
    primary key (id)
    );
    
create table Administrador (
	id int auto_increment,
    idUser int,
    nome varchar(100),
    cpf varchar(20),
    telefone varchar(100),
    primary key (id),
    foreign key (idUser) references usuario (id)
    );

create table Cliente(
	id int auto_increment,
    nome varchar(100),
    cpf varchar(20),
    telefone varchar (20),
    idUser int,
    primary key (id),
    foreign key (idUser) references Usuario (id)
    );

create table endereco (
	id int auto_increment,
    logradouro varchar(100),
    cep varchar(10),
    numero int,
    complemento varchar(100),
    bairro varchar(100),
    cidade varchar(100),
    uf  varchar(2),
    estado varchar(20),
    idCliente int,
    primary key (id),
    foreign key (idCliente) references Cliente (id)
    );
    
create table produto (
	id int auto_increment,
    nome varchar (100),
    marcar  varchar (100),
    descricao varchar (100),
    valor double,
    quantidade double,
    primary key (id)
	);

create table compra (
	id int auto_increment,
    totalCompra double,
    dataCompra date,
    horario time,
    idCliente int,
    primary key (id),
    foreign key (idCliente) references Cliente (id)
    );
    
create table itemCompra (
	idProduto int,
    idCompra int,
    quantidade int,
    valor double,
    foreign key (idProduto) references Produto (id),
    foreign key (idCompra) references Compra (id)
    );
    
create table Pagamento(
	id int auto_increment,
    dataPagamento date,
    totalComDesconto double,
    statusPagamento varchar(100),
    primary key (id)
    );
    
create table formaPagamento(
	id int auto_increment,
    desconto double,
    formaPagamento varchar(100),
    primary key (id)
    );
