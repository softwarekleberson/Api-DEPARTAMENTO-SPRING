create table cargos(
	
	id bigint not null auto_increment,
	nome varchar(100) not null,
	descricao varchar(200) not null, 
	salario_Base numeric(10,2) not null,
	salario_Maximo numeric(10,2) not null,
	nivel varchar(100) not null,
	
	primary key(id)
);