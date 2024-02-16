package api.rh.api.domain.cargo.regraNegocio.validarNovoCargo;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import api.rh.api.domain.cargo.infra.web.dto.post.DadosCadastroCargo;

@Service
public class ValidarMaiorSalarioPossivelCargo implements ValidarCriacaoCargo{

	private static final BigDecimal SALARIO_MAXIMO_DOS_CARGOS = new BigDecimal("30000.00");
	
	@Override
	public void validar(DadosCadastroCargo dados) {
		
		BigDecimal salario_do_cargo = dados.salarioMaximo();
		
		if(salario_do_cargo.compareTo(SALARIO_MAXIMO_DOS_CARGOS) > 0) {
			throw new IllegalArgumentException("O salário máximo não pode exceder o valor de " + SALARIO_MAXIMO_DOS_CARGOS);
		}
	}
}
