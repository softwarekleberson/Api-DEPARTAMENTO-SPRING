package api.rh.api.domain.funcionario.regrasNegocio.ValidarNovoFuncionario;

import java.math.BigDecimal;

import api.rh.api.commun.domain.humanResource.ValidacaoException;
import api.rh.api.domain.funcionario.infra.web.dto.post.DadosCadastroFuncionarios;

public class ValidarSalarioMinimoFuncionario implements ValidarCriacaoFuncionario {

	private static final BigDecimal SALARIO_MINIMO = new BigDecimal("1412.00");
	
	@Override
	public void validar(DadosCadastroFuncionarios dados) {
		
		BigDecimal salarioFuncionario = dados.funcionario().salario();
		if(salarioFuncionario.compareTo(SALARIO_MINIMO) < 0) {
            throw new ValidacaoException("Salario deve ser igual ou "
            						   + "superior ao mínimo: " + SALARIO_MINIMO);
		}
		
	}

}
