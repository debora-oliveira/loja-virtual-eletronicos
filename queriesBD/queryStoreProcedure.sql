DELIMITER $$
CREATE PROCEDURE insereCliente (IN email varchar(100), IN senha varchar(100), IN nome varchar(100), IN cpf varchar(100), IN telefone varchar(100))
BEGIN
	set @aux = 0;
    insert into usuario (usuario.email, usuario.senha)
    VALUES (email, senha);
    
    set @aux = (select usuario.id from usuario
    where usuario.email = email
    and usuario.senha = senha)
    ;
    
    insert into cliente (cliente.nome, cliente.cpf, cliente.telefone, cliente.idUser)
    VALUES (nome, cpf, telefone, @aux);
    
END $$
DELIMITER ;

-- TESTES CLIENTE
select @aux = usuario.id from usuario
    where usuario.email = "exemplo@meuemail.com"
    and usuario.senha = "1234"
    ;

call insereCliente ("exemplo@meuemail.com", "1234", "fulana", "1234567890", "1234-4321");

select * from usuario;
select * from cliente;
drop procedure insereCliente;
-- delete from usuario;

DELIMITER $$
CREATE PROCEDURE insereAdministrador (IN email varchar(100), IN senha varchar(100), IN nome varchar(100), IN cpf varchar(100), IN telefone varchar(100))
BEGIN
	set @aux = 0;
    insert into usuario (usuario.email, usuario.senha)
    VALUES (email, senha);
    
    set @aux = (select usuario.id from usuario
    where usuario.email = email
    and usuario.senha = senha)
    ;
    
    insert into administrador (administrador.nome, administrador.cpf, administrador.telefone, administrador.idUser)
    VALUES (nome, cpf, telefone, @aux);
    
END $$
DELIMITER ;

-- TESTES ADMIN

call insereAdministrador ("ADMIN@meuemail.com", "1234", "CICLANA", "1234567890", "9999-9999");

select * from usuario;
select * from administrador;
-- delete from usuario;
drop procedure insereAdministrador;