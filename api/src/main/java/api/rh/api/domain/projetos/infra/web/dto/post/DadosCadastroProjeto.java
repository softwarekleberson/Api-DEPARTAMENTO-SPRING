package api.rh.api.domain.projetos.infra.web.dto.post;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroProjeto(
		
		@NotNull
		Long idDepartamento,
		
		@NotNull
		String nome,
		
		@NotNull
		String descricao,
		
		@NotNull
		BigDecimal custo,
		
		@Future
		LocalDate terminoProjeto
		
												) {
}
