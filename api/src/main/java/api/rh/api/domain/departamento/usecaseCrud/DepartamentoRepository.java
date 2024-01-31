package api.rh.api.domain.departamento.usecaseCrud;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import api.rh.api.domain.departamento.entity.Departamento;
import api.rh.api.domain.departamento.infra.web.dto.put.DadosAtualizarDepartamento;
import jakarta.validation.Valid;

public interface DepartamentoRepository {

	void executeCreate(Departamento departamento);
	Page listAssets(Pageable paginacao);
	Departamento listAllDate(Long id);
	Departamento updateDate(@Valid DadosAtualizarDepartamento dados);
	void exclusionLogics(Long id);
	void exclusion(Departamento departamento);
}
