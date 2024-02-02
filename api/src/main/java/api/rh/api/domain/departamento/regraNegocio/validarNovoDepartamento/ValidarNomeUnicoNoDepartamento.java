package api.rh.api.domain.departamento.regraNegocio.validarNovoDepartamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.rh.api.commun.domain.humanResource.ValidacaoException;
import api.rh.api.domain.departamento.infra.persistencia.jpa.DepartamentoRepositoryJpa;
import api.rh.api.domain.departamento.infra.web.dto.post.DadosCadastroDepartamento;

@Service
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
