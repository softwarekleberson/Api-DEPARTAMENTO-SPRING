package api.rh.api.cargo;

import java.math.BigDecimal;

public record DadosCadastroCargo(String nome, String descricao,
								 BigDecimal salarioBase,
								 BigDecimal salarioMaximo,
								 NivelEstagio nivel) {

}
