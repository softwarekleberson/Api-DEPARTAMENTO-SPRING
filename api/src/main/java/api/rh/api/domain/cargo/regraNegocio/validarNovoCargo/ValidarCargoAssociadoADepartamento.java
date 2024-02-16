package api.rh.api.domain.cargo.regraNegocio.validarNovoCargo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.rh.api.commun.domain.humanResource.ValidacaoException;
import api.rh.api.domain.cargo.infra.web.dto.post.DadosCadastroCargo;
import api.rh.api.domain.departamento.infra.persistencia.jpa.DepartamentoRepositoryJpa;

@Service
public class ValidarCargoAssociadoADepartamento implements ValidarCriacaoCargo{
	
	@Autowired
	private DepartamentoRepositoryJpa repository;
	
	@Override
	public void validar(DadosCadastroCargo dados) {		
		
		long idDepartamento = dados.idDepartamento();
		boolean departamentoAtivo = repository.existsByAtivoTrueAndId(idDepartamento);
		
		if(!departamentoAtivo) {
			throw new ValidacaoException("O departamento está inativo ou não existe. Por favor, verifique e selecione um departamento válido.");
		}
	}
}
