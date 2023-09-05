package api.rh.api.domain.cargo.infra.web.dto;


import java.math.BigDecimal;

public record DadosCadastroCargo(String nome, String descricao,
								 BigDecimal salarioBase,
								 BigDecimal salarioMaximo,
								 NivelEstagio nivel) {

}
