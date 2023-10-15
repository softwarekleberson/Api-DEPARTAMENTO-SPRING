package api.rh.api.domain.projetos.infra.web.dto.put;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarProjeto(
		
		@NotNull
		Long id,
		
		BigDecimal custo
												) {
}
