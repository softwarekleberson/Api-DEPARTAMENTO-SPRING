package api.rh.api.commun.domain.humanResource.contato;

import jakarta.validation.constraints.Pattern;

public record DadosCadastroTelefone (
		
		@Pattern(regexp = "\\d{3}")
		String ddi,
		
		@Pattern(regexp = "\\d{2}")
		String ddd,
		
		@Pattern(regexp = "\\d{8,9")
		String telefone) {
}
