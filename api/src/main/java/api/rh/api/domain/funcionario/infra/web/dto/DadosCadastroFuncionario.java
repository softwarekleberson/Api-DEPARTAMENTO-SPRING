package api.rh.api.domain.funcionario.infra.web.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroFuncionario(
		
		@NotNull @Valid DadosCadastroPessoa pessoa,
		
		LocalDate contratacao,
		
	    @DecimalMin(value = "1500.00", inclusive = true, message = "O salario minimo é de 1.499")
		BigDecimal salario) {

}
