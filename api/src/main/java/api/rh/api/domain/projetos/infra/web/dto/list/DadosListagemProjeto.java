package api.rh.api.domain.projetos.infra.web.dto.list;

import java.math.BigDecimal;

import api.rh.api.domain.projetos.entity.Projeto;

public record DadosListagemProjeto(
		
		String nome,
		String descricao,
		BigDecimal custo
		
		) {

	public DadosListagemProjeto(Projeto projeto) {
		this(projeto.getNome(),
			 projeto.getDescricao(),
			 projeto.getCustoProjeto());
	}
}
