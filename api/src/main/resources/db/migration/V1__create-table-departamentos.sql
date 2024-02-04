CREATE TABLE departamentos (
    id bigint not null auto_increment,
    nome varchar(200) not null,
    ativo tinyint not null default 1,
    descricao varchar(500) not null,
    criacao date not null,
    ano DATE,
    orcamento DECIMAL(10, 2),
    saldo DECIMAL(10, 2),
    ddd char(2) not null,
    ddi char(3) not null,
    telefone varchar(9) not null, 
    email varchar(50) not null,
    pais varchar(100) not null,
    estado varchar(100) not null,
    cidade varchar(100) not null,
    rua varchar(200) not null,
    numero varchar(20) not null,
    complemento varchar(200),
    cep char(8) not null,
    
    primary key(id)
);