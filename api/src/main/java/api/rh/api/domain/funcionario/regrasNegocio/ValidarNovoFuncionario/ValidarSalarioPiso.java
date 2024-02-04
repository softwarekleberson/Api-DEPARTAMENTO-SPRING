package api.rh.api.domain.funcionario.regrasNegocio.ValidarNovoFuncionario;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import api.rh.api.commun.domain.humanResource.ValidacaoException;
import api.rh.api.domain.funcionario.infra.web.dto.post.DadosCadastroFuncionarios;

@Service
public class ValidarSalarioPiso implements ValidarCriacaoFuncionario{
	
	private static final BigDecimal PISO_NACIONAL = new BigDecimal("1412.00");
	
	@Override
	public void validar(DadosCadastroFuncionarios dados) {
		
		var salarioFuncionario = dados.funcionario().salario();
		if(salarioFuncionario.compareTo(PISO_NACIONAL) < 0) {
			throw new ValidacaoException("Salario deve ser maior que o piso nacional");
		}
	}
}