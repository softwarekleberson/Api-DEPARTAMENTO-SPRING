package api.rh.api.commun.domain.humanResource.endereco.dtos;

import api.rh.api.commun.domain.humanResource.endereco.Estado;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroEstado(
		
		@NotNull @Valid
		DadosCadastroPais pais,
		
		@NotBlank(message = "Estado deve conter : " + Estado.MENOR_COMPRIMENTO_STRING + " caracteres")
		String estado
		
								) {

}
