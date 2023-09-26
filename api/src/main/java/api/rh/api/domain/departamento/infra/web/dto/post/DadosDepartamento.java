package api.rh.api.domain.departamento.infra.web.dto.post;

import java.time.LocalDate;

import api.rh.api.domain.departamento.entity.Departamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosDepartamento(
		
		@NotBlank(message = "Nome deve conter " + Departamento.MAXIMO_NOME_LENGTH + " caracteres")
		String nome,
		
		@NotBlank(message = "Descrição deve conter " + Departamento.MAXIMO_DESCRICAO_LENGTH + " caracteres")
		String descricao,
		
		@NotNull(message = "Data deve ter o formato correto")
		LocalDate criacao
		
		) {
}
