package api.rh.api.domain.funcionario.infra.web.dto.post;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroEmail(
		
		@NotBlank
		@Email(message = "Formato de Email incorreto")
		String email
		
		) {

}
