ALTER TABLE cargos
ADD CONSTRAINT fk_cargos_departamentos_id
FOREIGN KEY (departamentos_id)
REFERENCES departamentos(id);
