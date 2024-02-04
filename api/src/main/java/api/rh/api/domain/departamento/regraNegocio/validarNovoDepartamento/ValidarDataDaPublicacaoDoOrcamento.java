package api.rh.api.domain.departamento.regraNegocio.validarNovoDepartamento;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import api.rh.api.commun.domain.humanResource.ValidacaoException;
import api.rh.api.domain.departamento.infra.web.dto.post.DadosCadastroDepartamento;

@Service
public class ValidarDataDaPublicacaoDoOrcamento implements ValidarCriacaoDepartamento{

	@Override
	public void validar(DadosCadastroDepartamento dados) {
		
		LocalDate dataAtual = LocalDate.now();
		var dataPublicacaoOrcamento = dados.orcamento().ano();
		
		if(dataPublicacaoOrcamento.isBefore(dataAtual)) {
			throw new ValidacaoException("Data da publicação do orçamento deve ser"
									   + " no dia atual ou no futuro");
		}
	}
}
