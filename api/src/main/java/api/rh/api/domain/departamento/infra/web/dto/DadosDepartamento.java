package api.rh.api.domain.departamento.infra.web.dto;

import java.time.LocalDate;

public record DadosDepartamento(String nome, String descricao,
						   LocalDate criacao) {
}
