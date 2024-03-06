package api.rh.api.domain.reajusteSalarialNivelProfissional.regrasNegocio.ValidarNovoReajuste;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.rh.api.commun.domain.humanResource.ValidacaoException;
import api.rh.api.domain.funcionario.entity.Funcionario;
import api.rh.api.domain.funcionario.infra.persistencia.jpa.FuncionarioRepositoryJpa;
import api.rh.api.domain.reajusteSalarialNivelProfissional.infra.web.dto.post.DadosCadastroReajusteSalarioal;

@Service
public class ValidarDiferencaSalarialMaximaMinimaCargo implements ValidarNovoReajuste{

	@Autowired
	private FuncionarioRepositoryJpa repository;
	
	@Override
	public void validar(DadosCadastroReajusteSalarioal dados) {
		
		System.out.println("validar diferença salarial");
		Optional<Funcionario> optionalFuncionario = repository.findById(dados.idFuncionario());
		BigDecimal reajusteSalarial = dados.novoSalario();
		
		if (optionalFuncionario.isPresent()) {
			Funcionario funcionario = optionalFuncionario.get();
			BigDecimal salarioBase = funcionario.getCargo().getSalario_Base();
			BigDecimal salarioMaximo = funcionario.getCargo().getSalario_Maximo();
			
			if(reajusteSalarial.compareTo(salarioBase) < 0 || reajusteSalarial.compareTo(salarioMaximo) > 0) {
				throw new ValidacaoException("Salario incompativel");
			}
		}
		
		else {
			throw new ValidacaoException("Funcionário não encontrado com o ID fornecido.");
		}
	}
}