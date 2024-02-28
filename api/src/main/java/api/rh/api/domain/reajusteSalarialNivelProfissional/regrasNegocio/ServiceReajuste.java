package api.rh.api.domain.reajusteSalarialNivelProfissional.regrasNegocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.rh.api.commun.domain.humanResource.ValidacaoException;
import api.rh.api.domain.reajusteSalarialNivelProfissional.entity.ReajusteSalarioCargo;
import api.rh.api.domain.reajusteSalarialNivelProfissional.infra.persistencia.jpa.ReajusteRepositoryJpa;
import api.rh.api.domain.reajusteSalarialNivelProfissional.infra.web.dto.post.DadosCadastroReajusteSalarioal;
import api.rh.api.domain.reajusteSalarialNivelProfissional.infra.web.dto.post.DadosDetalhamentoReajuste;
import api.rh.api.domain.reajusteSalarialNivelProfissional.regrasNegocio.ValidarNovoReajuste.ValidarNovoReajuste;
import api.rh.api.domain.reajusteSalarialNivelProfissional.usecase.crud.ReajusteDaoJpa;

@Service
public class ServiceReajuste {

	@Autowired
	private ReajusteRepositoryJpa reajusteRepository; 
	
	@Autowired
	private ReajusteDaoJpa reajusteDaoJpa;
	
	@Autowired
	private List<ValidarNovoReajuste> validadores;
	
	public DadosDetalhamentoReajuste criar(DadosCadastroReajusteSalarioal dto) {
		if(!reajusteRepository.existsById(dto.idFuncionario())) {
			throw new ValidacaoException("Id não encontrado");
		}
		
		validadores.forEach(v -> v.validar(dto));
		ReajusteSalarioCargo reajuteSalarial = new ReajusteSalarioCargo(dto);
		reajusteDaoJpa.executeCreate(reajuteSalarial);
		
		return new DadosDetalhamentoReajuste(reajuteSalarial);
	}
}
