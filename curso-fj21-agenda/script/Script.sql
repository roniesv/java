--<ScriptOptions statementTerminator=";"/>

--exemplo no mysql.
create table contatos(
	id bigint not null auto_incremente;
	nome varchar (255),
	email varchar(255),
	dataNascimento date,
	primary key(id)

);

create table contatos(
    id serial,
    nome varchar (255),
	email varchar(255),
	dataNascimento date,
	primary key(id) 	

);
--serial gera sozinha a chave
insert into contatos(nome, email, datanascimento)
values
('test','test@gmail','yyyy-mm-dd')