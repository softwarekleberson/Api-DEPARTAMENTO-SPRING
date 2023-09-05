package api.rh.api.domain.departamento.infra.web.dto;

import java.time.LocalDate;

public record Departamento(String nome, String descricao,
						   LocalDate criacao) {
}
