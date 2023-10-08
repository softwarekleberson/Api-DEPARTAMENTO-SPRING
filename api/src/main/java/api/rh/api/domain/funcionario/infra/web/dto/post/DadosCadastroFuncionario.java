package api.rh.api.domain.funcionario.infra.web.dto.post;

import java.math.BigDecimal;
import java.time.LocalDate;

import api.rh.api.commun.domain.humanResource.contato.DadosCadastroTelefone;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroFuncionario(
		
		@NotNull @Valid
		DadosCadastroPessoa pessoa,
		
		@NotNull
		LocalDate contratacao,
		
	    @DecimalMin(value = "1500.00", inclusive = true, message = "O salario minimo é de 1.499")
		BigDecimal salario,
	
		@NotNull @Valid
		DadosCadastroEmail email,
	
		DadosCadastroTelefone telefone,
		
		@NotNull(message = "Profissão deve ser valida")
		Profissao profissao
		
										)
																				{
}
