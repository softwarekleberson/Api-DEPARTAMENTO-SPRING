package api.rh.api.domain.cargo.validacoes.validarNovoCargo;

import api.rh.api.domain.cargo.infra.web.dto.post.DadosCadastroCargo;

public interface ValidarCriacaoCargo {

	void validar(DadosCadastroCargo dados);
}
