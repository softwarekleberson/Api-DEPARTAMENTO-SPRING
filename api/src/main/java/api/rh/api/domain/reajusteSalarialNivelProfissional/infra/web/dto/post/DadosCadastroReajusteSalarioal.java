package api.rh.api.domain.reajusteSalarialNivelProfissional.infra.web.dto.post;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroReajusteSalarioal(
		
		@NotNull
		BigDecimal novoSalario,	
		
		@NotNull
		LocalDate diaAtualizacao
		
		) {

}
