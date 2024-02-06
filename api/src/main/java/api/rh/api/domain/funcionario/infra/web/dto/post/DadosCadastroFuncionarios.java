package api.rh.api.domain.funcionario.infra.web.dto.post;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroFuncionarios(
		
		@NotNull
		Long idCargo,
		
		@NotNull @Valid DadosCadastroFuncionario funcionario		
				
										) 
										{
}
