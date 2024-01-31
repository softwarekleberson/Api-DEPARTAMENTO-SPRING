package api.rh.api.domain.funcionario.regrasNegocio.ValidarNovoFuncionario;

import api.rh.api.domain.funcionario.infra.web.dto.post.DadosCadastroFuncionarios;

public interface ValidarCriacaoFuncionario {

	void validar(DadosCadastroFuncionarios dados);
}
