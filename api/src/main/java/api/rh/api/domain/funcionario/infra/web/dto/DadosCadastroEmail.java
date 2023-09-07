package api.rh.api.domain.funcionario.infra.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroEmail(
		
		@NotBlank(message = "Campo Email vazio ou nulo")
		@Email(message = "Email no formato errado")
		String email
		
		) {

}
