package api.rh.api.domain.funcionario.infra.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroEmail(
		
		@NotBlank
		@Email
		String email
		
		) {

}
