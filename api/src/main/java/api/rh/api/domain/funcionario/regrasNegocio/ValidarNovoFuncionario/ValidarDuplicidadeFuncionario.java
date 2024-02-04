package api.rh.api.domain.funcionario.regrasNegocio.ValidarNovoFuncionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import api.rh.api.commun.domain.humanResource.ValidacaoException;
import api.rh.api.commun.domain.humanResource.cpf.Cpf;
import api.rh.api.domain.funcionario.infra.persistencia.jpa.FuncionarioRepositoryJpa;
import api.rh.api.domain.funcionario.infra.web.dto.post.DadosCadastroFuncionarios;


@Service
public class ValidarDuplicidadeFuncionario implements ValidarCriacaoFuncionario{

	@Autowired
	private FuncionarioRepositoryJpa repository;
	
	@Override
	public void validar(DadosCadastroFuncionarios dados) {
		String cpfFuncionario = dados.funcionario().pessoa().cpf().cpf();
		Cpf cpfconsulta = new Cpf(cpfFuncionario);
		
		boolean cpfCadastrado = repository.existsByCpfAndAtivoTrue(cpfconsulta);
		if(cpfCadastrado) {
			throw new ValidacaoException("Cpf cadastrado anteriormente");
		}
	}
}
