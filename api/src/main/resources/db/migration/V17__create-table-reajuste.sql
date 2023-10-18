CREATE TABLE reajustes (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(200) NOT NULL,
    dia_reajuste DATE NOT NULL,
    valor_reajuste numeric(10,2) NOT NULL,
    status_projeto VARCHAR(200),
    funcionarios_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_reajuste_funcionarios_id FOREIGN KEY (funcionarios_id) REFERENCES funcionarios(id)
);
