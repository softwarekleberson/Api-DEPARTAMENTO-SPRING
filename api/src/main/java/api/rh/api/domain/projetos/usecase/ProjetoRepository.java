package api.rh.api.domain.projetos.usecase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import api.rh.api.domain.projetos.entity.Projeto;
import api.rh.api.domain.projetos.infra.web.dto.put.DadosAtualizarProjeto;
import jakarta.validation.Valid;

public interface ProjetoRepository {

	void executeCreate(Projeto projeto);
	Projeto listAllDate(Long id);
	Projeto updateData(@Valid DadosAtualizarProjeto dados);
	void exclusionLogic(Long id);
	void exclusion(Projeto cargo);
	Page listAssets (Pageable paginacao);
}
