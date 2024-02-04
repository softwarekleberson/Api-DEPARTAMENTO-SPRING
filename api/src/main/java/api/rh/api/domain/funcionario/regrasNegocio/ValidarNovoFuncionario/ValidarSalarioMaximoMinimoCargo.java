package api.rh.api.domain.funcionario.regrasNegocio.ValidarNovoFuncionario;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.rh.api.commun.domain.humanResource.ValidacaoException;
import api.rh.api.domain.cargo.entity.Cargo;
import api.rh.api.domain.cargo.infra.persistencia.jpa.CargoRepositoryJpa;
import api.rh.api.domain.funcionario.infra.web.dto.post.DadosCadastroFuncionarios;

@Service
public class ValidarSalarioMaximoMinimoCargo implements ValidarCriacaoFuncionario{

	@Autowired
	private CargoRepositoryJpa repository;
	
	@Override
	public void validar(DadosCadastroFuncionarios dados) {
		
		var idFuncionario = dados.idCargo();
		Cargo cargo = repository.recuperaCargo(idFuncionario);
		
		BigDecimal salario = dados.funcionario().salario();
		BigDecimal menorSalario = cargo.getSalario_Base();
		BigDecimal maiorSalario = cargo.getSalario_Maximo();
		
		if(salario.compareTo(menorSalario) < 0 || salario.compareTo(maiorSalario) > 0) {
		    throw new ValidacaoException("Salario deve estar dentro do intervalo predefinido para o cargo");
		}

	}
}