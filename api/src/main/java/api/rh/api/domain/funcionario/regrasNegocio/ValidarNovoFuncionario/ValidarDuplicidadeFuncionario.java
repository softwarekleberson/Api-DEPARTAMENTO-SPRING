package api.rh.api.domain.funcionario.regrasNegocio.ValidarNovoFuncionario;

import org.springframework.beans.factory.annotation.Autowired;

import api.rh.api.commun.domain.humanResource.ValidacaoException;
import api.rh.api.domain.funcionario.infra.persistencia.jpa.FuncionarioRepositoryJpa;
import api.rh.api.domain.funcionario.infra.web.dto.post.DadosCadastroFuncionarios;

public class ValidarDuplicidadeFuncionario implements ValidarCriacaoFuncionario{

	@Autowired
	private FuncionarioRepositoryJpa repository;
	
	@Override
	public void validar(DadosCadastroFuncionarios dados) {
		String cpfFuncionario = dados.funcionario().pessoa().cpf().cpf().trim();
		boolean cpfCadastrado = repository.existsByCpf(cpfFuncionario);
		
		if(cpfCadastrado) {
			throw new ValidacaoException("Funcionario cadastrado anteriormente");
		}
	}
}
