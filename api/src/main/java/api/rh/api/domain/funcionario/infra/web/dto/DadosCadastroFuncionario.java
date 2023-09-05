package api.rh.api.domain.funcionario.infra.web.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosCadastroFuncionario(DadosCadastroPessoa pessoa,
						  LocalDate contratacao,
						  BigDecimal salario) {

}
