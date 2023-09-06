CREATE TABLE funcionarios (
    id bigint NOT NULL AUTO_INCREMENT,
    contratacao date NOT NULL,
    salario numeric(10, 2) NOT NULL,
    nome varchar(200) NOT NULL,
    nascimento date NOT NULL,
    sexo char(1),
    cpf char(11) NOT NULL,
    email varchar(200) NOT NULL,
    ddd char(2),
    ddi char(3),
    telefone varchar(9),
    profissao varchar(50) NOT NULL,
    PRIMARY KEY (id)
);