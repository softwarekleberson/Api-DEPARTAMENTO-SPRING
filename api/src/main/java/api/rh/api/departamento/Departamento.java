package api.rh.api.departamento;

import java.time.LocalDate;

public record Departamento(String nome, String descricao,
						   LocalDate criacao) {
}
