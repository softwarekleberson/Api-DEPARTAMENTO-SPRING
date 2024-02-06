package api.rh.api.domain.funcionario.infra.web.dto.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroCpf(
		
		@NotBlank
		@Pattern(regexp = "^\\d{11}", message="Apenas digitos")
		String cpf
		
		) {
}
