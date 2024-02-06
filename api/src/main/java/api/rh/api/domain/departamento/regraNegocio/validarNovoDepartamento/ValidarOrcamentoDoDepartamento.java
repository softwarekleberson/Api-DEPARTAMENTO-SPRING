package api.rh.api.domain.departamento.regraNegocio.validarNovoDepartamento;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import api.rh.api.commun.domain.humanResource.ValidacaoException;
import api.rh.api.domain.departamento.infra.web.dto.post.DadosCadastroDepartamento;

@Service
public class ValidarOrcamentoDoDepartamento implements ValidarCriacaoDepartamento{

	public static final BigDecimal MAIOR_ORCAMENTO_PERMITIDO
								   = new BigDecimal("5000000.00");
	
	@Override
	public void validar(DadosCadastroDepartamento dados) {
		
		var orcamentoDepartamento = dados.orcamento().orcamento();
		if(orcamentoDepartamento.compareTo(MAIOR_ORCAMENTO_PERMITIDO) > 0) {
			throw new ValidacaoException("Orcamento maior que o permitido");
		}
	}
}
