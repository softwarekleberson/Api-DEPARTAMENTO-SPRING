package api.rh.api.domain.funcionario.infra.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroCpf(
		
		@NotBlank
		@Pattern(regexp = "\\d{11}")
		String cpf
		) {
}
