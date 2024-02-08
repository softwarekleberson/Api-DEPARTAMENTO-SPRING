package api.rh.api.commun.domain.humanResource.endereco.dtos;

import api.rh.api.commun.domain.humanResource.endereco.Pais;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroPais(
		
		@NotBlank(message = "Pais deve conter : " + Pais.MENOR_STRING_PAIS_LENGT + "caracteres")
		String pais
		
							   ) {

}
