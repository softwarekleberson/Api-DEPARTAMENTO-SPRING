package api.rh.api.domain.departamento.usecase.crud;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import api.rh.api.domain.departamento.entity.Departamento;
import api.rh.api.domain.departamento.infra.persistencia.jpa.DepartamentoRepoitoryJpa;
import api.rh.api.domain.departamento.infra.web.dto.list.DadosListagemDepartamento;
import api.rh.api.domain.departamento.infra.web.dto.put.DadosAtualizarDepartamento;
import api.rh.api.domain.departamento.usecase.DepartamentoRepository;
import jakarta.validation.Valid;

public class DepartamentoDaoJpa implements DepartamentoRepository{

	private DepartamentoRepoitoryJpa departamentoRepoitory;
	
	public DepartamentoDaoJpa( DepartamentoRepoitoryJpa departamentoRepoitory) {
		this.departamentoRepoitory = departamentoRepoitory;
	}

	@Override
	public void executeCreate(Departamento departamento) {
		departamentoRepoitory.save(departamento);
	}

	@Override
	public Page listAssets(Pageable paginacao) {
		return departamentoRepoitory.findByAtivoTrue(paginacao).map(DadosListagemDepartamento::new);
	}

	@Override
	public Departamento listarAllDate(Long id) {
		return departamentoRepoitory.getReferenceById(id);
	}

	@Override
	public Departamento updateDate(@Valid DadosAtualizarDepartamento dados) {
		Optional<Departamento> optDataBase = departamentoRepoitory.findById(dados.id());
		
		if(optDataBase.isPresent()){
			Departamento databaseDepartamento = optDataBase.get();
			
			if(dados.nome() != null) {
				databaseDepartamento.setNome(dados.nome());
			}
			
			if(dados.descricao() != null) {
				databaseDepartamento.setDescricao(dados.descricao());
			}
			
			if(dados.endereco() != null) {
				databaseDepartamento.getEndereco().atualizarEndereco(dados.endereco());
			}
			
			if(dados.telefone() != null) {
				databaseDepartamento.getTelefone().atualizarTelefone(dados.telefone());
			}
			
			departamentoRepoitory.save(databaseDepartamento);
			return databaseDepartamento;
		}
		return null;
	}

	public void exclusionLogics(Long id) {
		var departamento = departamentoRepoitory.getReferenceById(id);
		exclusion(departamento);
	}
	
	public void exclusion(Departamento departamento) {
		departamento.setAtivo(false);
	}
		
}
