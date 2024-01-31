package api.rh.api.domain.funcionario.usecaseCrud;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import api.rh.api.domain.funcionario.entity.Funcionario;
import api.rh.api.domain.funcionario.infra.web.dto.put.DadosAtualizarFuncionario;
import jakarta.validation.Valid;

public interface FuncionarioRepository {

	void executeCreate(Funcionario funcionario);
	Page listAssets(Pageable paginacao);
	Funcionario listAllDate(Long id);
	Funcionario updateDate(@Valid DadosAtualizarFuncionario dados);
	void exclusionLogics(Long id); 
	void exclusion(Funcionario funcionario);
	 
}
