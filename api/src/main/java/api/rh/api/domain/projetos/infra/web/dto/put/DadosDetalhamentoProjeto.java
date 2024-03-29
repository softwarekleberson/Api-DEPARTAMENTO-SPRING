package api.rh.api.domain.projetos.infra.web.dto.put;

import java.math.BigDecimal;
import java.time.LocalDate;

import api.rh.api.domain.projetos.entity.Projeto;
import api.rh.api.domain.projetos.entity.StatusProjeto;

public record DadosDetalhamentoProjeto(
		
		Long id,
		String nome,
		String descricao,
		BigDecimal custoProjeto,
		StatusProjeto status,
		LocalDate inicioprojeto,
		LocalDate fimProjeto
		
		) {

		public DadosDetalhamentoProjeto(Projeto projeto) {
			this(projeto.getId(),projeto.getNome(),
				projeto.getDescricao(), projeto.getCustoProjeto(),
				projeto.getStatusProjeto(), projeto.getInicioProjeto(),
				projeto.getTerminoProjeto());
		}
}
