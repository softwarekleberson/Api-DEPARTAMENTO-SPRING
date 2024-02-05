package api.rh.api.domain.projetos.regrasNegocio.ValidarNovoProjeto;

import api.rh.api.domain.projetos.infra.web.dto.post.DadosCadastroProjeto;

public interface ValidarNovoProjeto {

	void validar(DadosCadastroProjeto dados);
}
