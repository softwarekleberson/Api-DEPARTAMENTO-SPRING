package api.rh.api.domain.cargo.regraNegocio.validarNovoCargo;

import org.springframework.stereotype.Service;

import api.rh.api.commun.domain.humanResource.ValidacaoException;
import api.rh.api.domain.cargo.infra.web.dto.post.DadosCadastroCargo;

@Service
public class ValidarDiferencaEntreSalarioMaximoEMinimo implements ValidarCriacaoCargo{

	@Override
	public void validar(DadosCadastroCargo dados) {
		
		var salarioMaximo = dados.salarioMaximo();
		var salarioBase = dados.salarioBase();
		
		if(salarioBase.compareTo(salarioMaximo) > 0) {
			throw new ValidacaoException("O salário base fornecido é superior ao valor máximo permitido. Por favor, insira um salário dentro do limite estabelecido.");
		}	
	}
}
