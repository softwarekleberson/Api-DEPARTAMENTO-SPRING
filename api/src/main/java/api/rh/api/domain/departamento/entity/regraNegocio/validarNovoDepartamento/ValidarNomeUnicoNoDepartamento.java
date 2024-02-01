package api.rh.api.domain.departamento.entity.regraNegocio.validarNovoDepartamento;

import org.springframework.beans.factory.annotation.Autowired;

import api.rh.api.commun.domain.humanResource.ValidacaoException;
import api.rh.api.domain.departamento.infra.persistencia.jpa.DepartamentoRepositoryJpa;
import api.rh.api.domain.departamento.infra.web.dto.post.DadosCadastroDepartamento;

public class ValidarNomeUnicoNoDepartamento implements ValidarCriacaoDepartamento{

	@Autowired
	private DepartamentoRepositoryJpa repository;
	
	@Override
	public void validar(DadosCadastroDepartamento dados) {
		
		var nomeDepartamento = dados.departamento().nome().trim();
		boolean departamentoCadastrado = repository.existsByNome(nomeDepartamento);
		
		if(departamentoCadastrado) {
			throw new ValidacaoException("Departamento cadastrado anteriormente");
		}
	}

}
