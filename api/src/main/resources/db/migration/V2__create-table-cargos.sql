CREATE TABLE cargos (
    id bigint not null auto_increment,
    ativo tinyint not null default 1,
    nome varchar(100) not null,
    descricao varchar(200) not null, 
    salario_Base numeric(10,2) not null,
    salario_Maximo numeric(10,2) not null,
    nivel varchar(100) not null,
    departamento_id bigint not null,
    
    primary key(id),
    FOREIGN KEY (departamento_id) REFERENCES departamentos(id)
);