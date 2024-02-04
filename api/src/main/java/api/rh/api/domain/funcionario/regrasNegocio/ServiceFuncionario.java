package api.rh.api.domain.funcionario.regrasNegocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.rh.api.commun.domain.humanResource.ValidacaoException;
import api.rh.api.domain.cargo.infra.persistencia.jpa.CargoRepositoryJpa;
import api.rh.api.domain.funcionario.entity.Funcionario;
import api.rh.api.domain.funcionario.infra.web.dto.post.DadosCadastroFuncionarios;
import api.rh.api.domain.funcionario.infra.web.dto.put.DadosDetalhamentoFuncionario;
import api.rh.api.domain.funcionario.regrasNegocio.ValidarNovoFuncionario.ValidarCriacaoFuncionario;
import api.rh.api.domain.funcionario.usecaseCrud.crud.CrudFuncionarioJpa;

@Service
public class ServiceFuncionario {
	
	@Autowired
	private CargoRepositoryJpa cargoRepository;
	
	@Autowired
	private CrudFuncionarioJpa daoFuncionario;
	
	@Autowired
	private List<ValidarCriacaoFuncionario> validacoes;
	
	public DadosDetalhamentoFuncionario criar(DadosCadastroFuncionarios dados) {
		
		var idCargo = dados.idCargo();
		boolean exixsteIdCargo =  cargoRepository.existsById(idCargo);
		
		if(!exixsteIdCargo) {
			throw new ValidacaoException("Id do cargo inexcistente");
		}

		validacoes.forEach(v-> v.validar(dados));
		Funcionario funcionarios = new Funcionario(dados);
		daoFuncionario.executeCreate(funcionarios);
		
		return new DadosDetalhamentoFuncionario(funcionarios);
	}
}
