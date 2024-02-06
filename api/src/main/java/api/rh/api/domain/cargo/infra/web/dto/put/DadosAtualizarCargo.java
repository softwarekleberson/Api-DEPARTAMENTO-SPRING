package api.rh.api.domain.cargo.infra.web.dto.put;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarCargo (
		
		@NotNull
		Long id,
		
		String nome,
		String descricao,
		BigDecimal salarioBase,
		BigDecimal salarioMaximo
		
								  ) {

}
