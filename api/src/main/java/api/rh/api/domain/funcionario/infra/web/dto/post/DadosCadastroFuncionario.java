package api.rh.api.domain.funcionario.infra.web.dto.post;

import java.math.BigDecimal;
import java.time.LocalDate;

import api.rh.api.commun.domain.humanResource.contato.DadosCadastroTelefone;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroFuncionario(
		
		@NotNull @Valid
		DadosCadastroPessoa pessoa,
		
		@NotNull
		LocalDate contratacao,
		
		BigDecimal salario,
	
		@NotNull @Valid
		DadosCadastroEmail email,
	
		DadosCadastroTelefone telefone,
		
		@NotNull(message = "Profissão deve ser valida")
		Profissao profissao
		
										)
																				{
}
