package api.rh.api.domain.reajusteSalarialNivelProfissional.regrasNegocio.ValidarNovoReajuste;

import api.rh.api.domain.reajusteSalarialNivelProfissional.infra.web.dto.post.DadosCadastroReajusteSalarioal;

public interface ValidarNovoReajuste {

	void validar(DadosCadastroReajusteSalarioal dados);
}
