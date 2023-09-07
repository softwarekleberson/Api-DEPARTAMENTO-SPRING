package api.rh.api.domain.funcionario.infra.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroCpf(
		
		@NotBlank(message = "O Cpf não pode estar vazio")
		@Pattern(regexp = "\\d{11}", message = "Cpf deve conter 11 digitos")
		String cpf
		) {
}
