package api.rh.api.domain.departamento.infra.web.dto.post;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.Future;

public record DadosCadastroOrcamento(
		
		@Future
		LocalDate ano,
		
		BigDecimal orcamento
		
		) 												{
}
