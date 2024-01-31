package api.rh.api.domain.departamento.entity.regraNegocio.validarNovoDepartamento;

import api.rh.api.domain.departamento.infra.web.dto.post.DadosCadastroDepartamento;

public interface ValidarCriacaoDepartamento {

	void validar(DadosCadastroDepartamento dados);
}
