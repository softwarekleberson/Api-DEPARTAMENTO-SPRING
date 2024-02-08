package api.rh.api.commun.domain.humanResource.endereco.dtos;

import api.rh.api.commun.domain.humanResource.endereco.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroEndereco(
		
		@NotNull @Valid
		DadosCadastroCidade cidade,
				
		@NotBlank(message = "Rua deve conter : " + Endereco.MENOR_COMPRIMENTO_STRING + " caracteres")
		String rua,
		
		@NotBlank
		String numero,
		
		String complemento,
		
		@NotBlank
		@Pattern(regexp = "\\d{5}|\\d{8}|\\d{9}", message = "CEP deve ter 5, 8 ou 9 dígitos")
		String cep

		 							) {
}
