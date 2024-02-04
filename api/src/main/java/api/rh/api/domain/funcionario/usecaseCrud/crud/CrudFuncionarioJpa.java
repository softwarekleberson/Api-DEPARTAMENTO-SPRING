package api.rh.api.domain.funcionario.usecaseCrud.crud;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import api.rh.api.domain.funcionario.entity.Funcionario;
import api.rh.api.domain.funcionario.infra.persistencia.jpa.FuncionarioRepositoryJpa;
import api.rh.api.domain.funcionario.infra.web.dto.list.DadosListagemFuncionario;
import api.rh.api.domain.funcionario.infra.web.dto.put.DadosAtualizarFuncionario;
import api.rh.api.domain.funcionario.usecaseCrud.FuncionarioRepository;
import jakarta.validation.Valid;

@Service
public class CrudFuncionarioJpa implements FuncionarioRepository{

	private FuncionarioRepositoryJpa funcionarioRepository;
	
	public CrudFuncionarioJpa(FuncionarioRepositoryJpa repository) {
		this.funcionarioRepository = repository;
	}

	@Override
	public void executeCreate(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
	}
	

	@Override
	public Page listAssets(Pageable paginacao) {
		return funcionarioRepository.findByAtivoTrue(paginacao).map(DadosListagemFuncionario ::new);
	}

	@Override
	public Funcionario listAllDate(Long id) {
		return funcionarioRepository.getReferenceById(id);
	}

	@Override
	public Funcionario updateDate(@Valid DadosAtualizarFuncionario dados) {
		
		Optional<Funcionario> optDataBase = funcionarioRepository.findById(dados.id());
		if(optDataBase.isPresent()) {
			Funcionario databaseFuncionario = optDataBase.get();
			
			if(dados.nome() != null) {
				databaseFuncionario.setNome(dados.nome());
			}
			
			if(dados.telefone() != null) {
				databaseFuncionario.setTelefone(dados.telefone());
			}

			funcionarioRepository.save(databaseFuncionario);
			return databaseFuncionario;
		}
		
		return null;
	}

	@Override
	public void exclusionLogics(Long id) {
		var funcionario = funcionarioRepository.getReferenceById(id);
		exclusion(funcionario);
	}
	
	@Override
	public void exclusion(Funcionario funcionario) {
		funcionario.setAtivo(false);
	}

}
