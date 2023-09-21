package api.rh.api.commun.domain.humanResource.contato;

import jakarta.validation.constraints.Pattern;

public record DadosCadastroTelefone (
		
		@Pattern(regexp = "\\d{3}", message = "Necessario 3 digitos")
		String ddi,
		
		@Pattern(regexp = "\\d{2}", message = "Necessario 2 digitos")
		String ddd,
		
		@Pattern(regexp = "\\d{8,9}", message ="Necesario 8 ou 9 digitos")
		String telefone) {
}
