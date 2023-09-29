package api.rh.api.commun.domain.humanResource.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroEndereco(
		
		@NotBlank(message = "Pais deve conter : " + Endereco.MENOR_STRING_PAIS_LENGT + " caracteres")
		String pais,
		
		@NotBlank(message = "Estado deve conter : " + Endereco.MENOR_COMPRIMENTO_STRING + " caracteres")
		String estado,
		
		@NotBlank(message = "Cidade deve conter : " + Endereco.MENOR_COMPRIMENTO_STRING + " caracteres")
		String cidade,
		
		@NotBlank(message = "Rua deve conter : " + Endereco.MENOR_COMPRIMENTO_STRING + " caracteres")
		String rua,
		
		String numero,
		
		String complemento,
		
		@NotBlank
		@Pattern(regexp = "\\d{5}|\\d{8}|\\d{9}", message = "CEP deve ter 5, 8 ou 9 dígitos")
		String cep

		 ) {
}
