package api.rh.api.commun.domain.humanResource.endereco.dtos;

import api.rh.api.commun.domain.humanResource.endereco.Cidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCidade(
		
		@NotNull @Valid
		DadosCadastroEstado estado,
		
		@NotBlank(message = "Cidade deve conter : " + Cidade.MENOR_COMPRIMENTO_STRING + " caracteres")
		String cidade
		
								) {

}
