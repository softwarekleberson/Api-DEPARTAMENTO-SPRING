package api.rh.api.commun.domain.humanResource.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroEndereco(
		
		@NotBlank
		String pais,
		
		@NotBlank
		String estado,
		
		@NotBlank
		String cidade,
		
		@NotBlank
		String rua,
		
		@NotBlank
		String numero,
		
		@NotBlank
		@Pattern(regexp = "\\d{5}|\\d{8}|\\d{9}", message = "CEP deve ter 5, 8 ou 9 dígitos")
		String cep

		 ) {
}
