alter table cargos
add ativo tinyint;

update cargos
set ativo = 1;