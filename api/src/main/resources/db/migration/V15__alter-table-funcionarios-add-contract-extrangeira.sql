ALTER TABLE funcionarios
ADD CONSTRAINT fk_funcionarios_cargos_id
FOREIGN KEY (cargos_id)
REFERENCES cargos(id);
