package api.rh.api.domain.funcionario.infra.web.dto.put;

import api.rh.api.domain.funcionario.infra.web.dto.post.Profissao;

public record DadosAtualizarFuncionario(
		
		Long id,
		String nome,
		String ddi,
		String ddd,
		String telefone,
		Profissao profissao
		
		) {

}
