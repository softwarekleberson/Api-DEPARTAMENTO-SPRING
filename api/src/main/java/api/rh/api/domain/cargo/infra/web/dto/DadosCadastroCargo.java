package api.rh.api.domain.cargo.infra.web.dto;


import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DadosCadastroCargo(
		
		@NotBlank
		String nome,
		
		@NotBlank
		String descricao,
		
		@Positive
		BigDecimal salarioBase,
		
		@Positive
		BigDecimal salarioMaximo,
		
		@NotNull
		NivelEstagio nivel
		
		) {
}
