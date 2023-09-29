package api.rh.api.domain.departamento.usecase;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import api.rh.api.domain.departamento.entity.Departamento;
import api.rh.api.domain.departamento.infra.persistencia.jpa.DepartamentoRepoitory;
import api.rh.api.domain.departamento.infra.web.dto.list.DadosListagemDepartamento;
import api.rh.api.domain.departamento.infra.web.dto.put.DadosAtualizarDepartamento;
import jakarta.validation.Valid;

public class CrudDepartamento {

	private DepartamentoRepoitory departamentoRepoitory;
	
	public CrudDepartamento( DepartamentoRepoitory departamentoRepoitory) {
		this.departamentoRepoitory = departamentoRepoitory;
	}

	public void criarDepartamento(Departamento departamento) {
		departamentoRepoitory.save(departamento);
	}

	public Page listarAtivo(Pageable paginacao) {
		return departamentoRepoitory.findByAtivoTrue(paginacao).map(DadosListagemDepartamento::new);
	}

	public Departamento listarAll(Long id) {
		return departamentoRepoitory.getReferenceById(id);
	}

	public Departamento atualizarDados(@Valid DadosAtualizarDepartamento dados) {
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

	public void exclusaoLogica(Long id) {
		var departamento = departamentoRepoitory.getReferenceById(id);
		excluir(departamento);
	}
	
	private void excluir(Departamento departamento) {
		departamento.setAtivo(false);
	}
	
	
}
