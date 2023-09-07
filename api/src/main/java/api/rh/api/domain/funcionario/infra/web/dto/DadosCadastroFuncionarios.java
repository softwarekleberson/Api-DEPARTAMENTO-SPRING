package api.rh.api.domain.funcionario.infra.web.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroFuncionarios(
		
		@NotNull @Valid DadosCadastroFuncionario funcionario,
		
		@NotNull(message = "Profissão deve ser valida")
		Profissao profissao
		) {
}
