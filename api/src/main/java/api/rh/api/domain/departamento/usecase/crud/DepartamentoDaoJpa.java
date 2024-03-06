package api.rh.api.domain.departamento.usecase.crud;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import api.rh.api.domain.departamento.entity.Departamento;
import api.rh.api.domain.departamento.infra.persistencia.jpa.DepartamentoRepositoryJpa;
import api.rh.api.domain.departamento.infra.web.dto.list.DadosListagemDepartamento;
import api.rh.api.domain.departamento.infra.web.dto.put.DadosAtualizarDepartamento;
import api.rh.api.domain.departamento.usecase.DepartamentoRepository;
import jakarta.validation.Valid;

@Service
public class DepartamentoDaoJpa implements DepartamentoRepository{

	private DepartamentoRepositoryJpa departamentoRepository;
	
	public DepartamentoDaoJpa( DepartamentoRepositoryJpa departamentoRepoitory) {
		this.departamentoRepository = departamentoRepoitory;
	}

	@Override
	public void executeCreate(Departamento departamento) {
		departamentoRepository.save(departamento);
	}

	@Override
	public Page listAssets(Pageable paginacao) {
		return departamentoRepository.findByAtivoTrue(paginacao).map(DadosListagemDepartamento::new);
	}

	@Override
	public Departamento listAllDate(Long id) {
		return departamentoRepository.getReferenceById(id);
	}

	@Override
	public Departamento updateDate(@Valid DadosAtualizarDepartamento dados) {
		Optional<Departamento> optDataBase = departamentoRepository.findById(dados.id());
		
		if(optDataBase.isPresent()){
			Departamento databaseDepartamento = optDataBase.get();
			
			if(dados.nome() != null) {
				databaseDepartamento.setNome(dados.nome());
			}
			
			if(dados.descricao() != null) {
				databaseDepartamento.setDescricao(dados.descricao());
			}
			
			if(dados.endereco() != null) {
				databaseDepartamento.setEndereco(dados.endereco());
			}
			
			if(dados.telefone() != null) {
				databaseDepartamento.setTelefone(dados.telefone());
			}
			
			departamentoRepository.save(databaseDepartamento);
			return databaseDepartamento;
		}
		return null;
	}

	@Override
	public void exclusionLogics(Long id) {
		var departamento = departamentoRepository.getReferenceById(id);
		exclusion(departamento);
	}
	
	@Override
	public void exclusion(Departamento departamento) {
		departamento.setAtivo(false);
	}

	@Override
	public void subtrairCustosDoOrcamento(Departamento departamento, BigDecimal orcamentoAtualizado) {
		departamento.setOrcamento(orcamentoAtualizado);
	}
}