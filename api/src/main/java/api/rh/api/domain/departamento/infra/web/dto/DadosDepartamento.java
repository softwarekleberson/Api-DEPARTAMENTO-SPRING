package api.rh.api.domain.departamento.infra.web.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosDepartamento(
		
		@NotBlank
		String nome,
		
		@NotBlank
		String descricao,
		
		@NotNull
		LocalDate criacao
		
		) {
}
