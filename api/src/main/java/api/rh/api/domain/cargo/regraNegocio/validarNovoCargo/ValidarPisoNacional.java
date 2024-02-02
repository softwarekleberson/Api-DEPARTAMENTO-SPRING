package api.rh.api.domain.cargo.regraNegocio.validarNovoCargo;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import api.rh.api.commun.domain.humanResource.ValidacaoException;
import api.rh.api.domain.cargo.infra.web.dto.post.DadosCadastroCargo;

@Service
public class ValidarPisoNacional implements ValidarCriacaoCargo{

	private static final BigDecimal SALARIO_MINIMO = new BigDecimal("1412.00");
	
	@Override
	public void validar(DadosCadastroCargo dados) {
		
		BigDecimal menor_salario_cargo = dados.salarioBase();
		if(SALARIO_MINIMO.compareTo(menor_salario_cargo) > 0) {
			throw new ValidacaoException("Salario menor que o piso nacional");
		}	
	}
}