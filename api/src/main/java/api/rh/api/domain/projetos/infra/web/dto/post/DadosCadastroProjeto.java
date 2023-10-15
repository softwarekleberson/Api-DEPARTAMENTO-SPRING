package api.rh.api.domain.projetos.infra.web.dto.post;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroProjeto(
		
		@NotNull
		Long idProjeto,
		
		@NotNull
		String nome,
		
		@NotNull
		String descricao,
		
		@NotBlank
		BigDecimal custo,
		
		LocalDate terminoProjeto
		
												) {
}
