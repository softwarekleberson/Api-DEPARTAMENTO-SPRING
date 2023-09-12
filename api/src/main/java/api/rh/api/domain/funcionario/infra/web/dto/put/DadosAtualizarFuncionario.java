package api.rh.api.domain.funcionario.infra.web.dto.put;

import api.rh.api.commun.domain.humanResource.contato.DadosCadastroTelefone;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarFuncionario(
		
		@NotNull
		Long id,
		
		String nome,
		DadosCadastroTelefone telefone
		
		) {

}
