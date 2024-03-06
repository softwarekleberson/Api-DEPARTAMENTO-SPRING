CREATE TABLE reajustes (
    id BIGINT NOT NULL AUTO_INCREMENT,
    cpf CHAR(11) NOT NULL,
    dia_reajuste DATE NOT NULL,
    valor_reajuste NUMERIC(10,2) NOT NULL,
    motivo_reajuste VARCHAR(200),
    funcionario_id BIGINT NOT NULL,
    
    PRIMARY KEY (id),
    FOREIGN KEY (funcionario_id) REFERENCES funcionarios(id)
);
