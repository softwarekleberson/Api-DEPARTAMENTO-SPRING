package api.rh.api.domain.cargo.infra.web.dto.put;

import java.math.BigDecimal;

import jakarta.validation.constraints.Positive;

public record DadosAtualizarCargo(
		
		Long id,
		String nome,
		String descricao,
		
		@Positive
		BigDecimal salarioBase,
		
		@Positive
		BigDecimal salarioMaximo
		
		) {

}
