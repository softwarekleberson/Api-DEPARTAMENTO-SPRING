package api.rh.api.domain.cargo.regraNegocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.rh.api.commun.domain.humanResource.ValidacaoException;
import api.rh.api.domain.cargo.entity.Cargo;
import api.rh.api.domain.cargo.infra.persistencia.jpa.CargoRepositoryJpa;
import api.rh.api.domain.cargo.infra.web.dto.post.DadosCadastroCargo;
import api.rh.api.domain.cargo.infra.web.dto.post.NivelEstagio;
import api.rh.api.domain.cargo.infra.web.dto.put.DadosDetalhamentoCargo;
import api.rh.api.domain.cargo.regraNegocio.validarNovoCargo.ValidarCriacaoCargo;
import api.rh.api.domain.cargo.usecaseCrud.crud.CargoDaoJpa;
import api.rh.api.domain.departamento.infra.persistencia.jpa.DepartamentoRepositoryJpa;

@Service
public class ServiceCargo {

	@Autowired
	private CargoRepositoryJpa cargoRepository;
	
	@Autowired
	private DepartamentoRepositoryJpa departamentRepository;
	
	@Autowired
	private CargoDaoJpa daoCargo;
	
	@Autowired
	private List<ValidarCriacaoCargo> validadores;
	
	public DadosDetalhamentoCargo criar(DadosCadastroCargo dados) {
		
		if(!departamentRepository.existsById(dados.idDepartamento())) {
			throw new ValidacaoException("Id do departamento inexistente");
		}
				
		boolean gerentePresenteEmInput = (dados.nivel() == NivelEstagio.GERENTE);

		if(!gerentePresenteEmInput) {
			throw new ValidacaoException("Para que cargo pertença a departamento"
									   + " é necessario ao menos um gerente");
		}
		
		validadores.forEach(v -> v.validar(dados));
		
		var cargo = new Cargo(dados);
		daoCargo.executeCreate(cargo);
		
		return new DadosDetalhamentoCargo(cargo);
	}
}
