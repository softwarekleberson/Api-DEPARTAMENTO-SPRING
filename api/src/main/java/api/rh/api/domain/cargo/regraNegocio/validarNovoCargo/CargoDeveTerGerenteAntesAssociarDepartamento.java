package api.rh.api.domain.cargo.regraNegocio.validarNovoCargo;

import org.springframework.beans.factory.annotation.Autowired;

import api.rh.api.commun.domain.humanResource.ValidacaoException;
import api.rh.api.domain.cargo.infra.persistencia.jpa.CargoRepositoryJpa;
import api.rh.api.domain.cargo.infra.web.dto.post.DadosCadastroCargo;
import api.rh.api.domain.cargo.infra.web.dto.post.NivelEstagio;

public class CargoDeveTerGerenteAntesAssociarDepartamento implements ValidarCriacaoCargo {

	@Autowired
	private CargoRepositoryJpa repository;
	
	@Override
	public void validar(DadosCadastroCargo dados) {
		
		var existeGerente = dados.nivel();
		boolean verificarExistenciaGerente = repository.existsByNivel(existeGerente);

		if((existeGerente != NivelEstagio.GERENTE) || (!verificarExistenciaGerente)) {
			throw new ValidacaoException("Necessario Gerente antes de cargo"
										+ " fazer parte de departamento");
		}
	}
}
