CREATE TABLE projetos (

	id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(200) NOT NULL,
    ativo TINYINT,
    descricao VARCHAR(1000) NOT NULL,
    custo_projeto DECIMAL(10,2) NOT NULL,
    inicio_projeto DATE NOT NULL,
    termino_projeto DATE NOT NULL,
    status_projeto VARCHAR(200),
    departamentos_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_projetos_departamentos_id FOREIGN KEY (departamentos_id) REFERENCES departamentos(id)
);
