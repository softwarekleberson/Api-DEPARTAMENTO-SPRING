package api.rh.api.domain.cargo.infra.web.dto.post;
import java.math.BigDecimal;

import api.rh.api.domain.cargo.entity.Cargo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DadosCadastroCargo(
		
		@NotBlank(message = "Nome não deve ser nulo ou maior que : " + Cargo.MAXIMO_NOME_LENGTH + " caracteres")
		String nome,
		
		@NotBlank(message = "Descrição não deve ser nulo ou maior que : " + Cargo.MAXIMO_DESCRICAO_LENGTH + " caracteres")
		String descricao,
		
		@Positive(message = "Valor deve ser maior que 0 : ")
		BigDecimal salarioBase,
		
		@Positive(message = "Valor deve ser maior que 0")
		BigDecimal salarioMaximo,
		
		@NotNull(message = "Nível não deve ser nulo")
		NivelEstagio nivel,
		
		@NotNull
		Long idDepartamento
		
		) {
}
