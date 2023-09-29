package api.rh.api.domain.funcionario.usecase;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import api.rh.api.domain.departamento.entity.Departamento;
import api.rh.api.domain.funcionario.entity.Funcionario;
import api.rh.api.domain.funcionario.infra.persistencia.jpa.FuncionarioRepository;
import api.rh.api.domain.funcionario.infra.web.dto.list.DadosListagemFuncionario;
import api.rh.api.domain.funcionario.infra.web.dto.put.DadosAtualizarFuncionario;
import jakarta.validation.Valid;

public class CrudFuncionario {

	private FuncionarioRepository funcionarioRepository;
	
	public CrudFuncionario(FuncionarioRepository repository) {
		this.funcionarioRepository = repository;
	}

	public void criarFuncionario(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
	}

	public Page listarAtivo(Pageable paginacao) {
		return funcionarioRepository.findByAtivoTrue(paginacao).map(DadosListagemFuncionario ::new);
	}

	public Funcionario detalharFuncionario(Long id) {
		return funcionarioRepository.getReferenceById(id);
	}

	public Funcionario atualizarFuncionario(@Valid DadosAtualizarFuncionario dados) {
		
		Optional<Funcionario> optDataBase = funcionarioRepository.findById(dados.id());
		if(optDataBase.isPresent()) {
			Funcionario databaseFuncionario = optDataBase.get();
			
			if(dados.nome() != null) {
				databaseFuncionario.getPessoa().setNome(dados.nome());
			}
			
			if(dados.telefone() != null) {
				databaseFuncionario.getPessoa().getTelefone().atualizarTelefone(dados.telefone());
			}

			funcionarioRepository.save(databaseFuncionario);
			return databaseFuncionario;
		}
		
		return null;
	}

	public void exclusaoLogica(Long id) {
		var funcionario = funcionarioRepository.getReferenceById(id);
		excluir(funcionario);
	}
	
	private void excluir(Funcionario funcionario) {
		funcionario.setAtivo(false);
	}

	
	
}
