package api.rh.api.funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Funcionario(Pessoa pessoa, LocalDate contratacao,
						  BigDecimal salario, profissao profissao) {

}
