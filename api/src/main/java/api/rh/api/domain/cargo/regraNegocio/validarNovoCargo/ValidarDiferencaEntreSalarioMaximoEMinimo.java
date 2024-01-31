package api.rh.api.domain.cargo.regraNegocio.validarNovoCargo;

import api.rh.api.commun.domain.humanResource.ValidacaoException;
import api.rh.api.domain.cargo.infra.web.dto.post.DadosCadastroCargo;

public class ValidarDiferencaEntreSalarioMaximoEMinimo implements ValidarCriacaoCargo{

	@Override
	public void validar(DadosCadastroCargo dados) {
		
		var salarioMaximo = dados.salarioMaximo();
		var salarioBase = dados.salarioBase();
		
		if(salarioBase.compareTo(salarioMaximo) > 0) {
			throw new ValidacaoException("Salario base superior ao máximo");
		}	
	}
}
