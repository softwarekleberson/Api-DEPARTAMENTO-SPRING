package api.rh.api.domain.funcionario.infra.web.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Funcionario(Pessoa pessoa,
						  LocalDate contratacao,
						  BigDecimal salario) {

}
