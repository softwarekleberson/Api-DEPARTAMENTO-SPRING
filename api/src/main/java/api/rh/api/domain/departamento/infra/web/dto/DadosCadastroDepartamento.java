package api.rh.api.domain.departamento.infra.web.dto;

import api.rh.api.commun.domain.humanResource.contato.DadosCadastroTelefone;
import api.rh.api.commun.domain.humanResource.endereco.DadosCadastroEndereco;
import api.rh.api.domain.funcionario.infra.web.dto.DadosCadastroEmail;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroDepartamento(
		
		@NotNull @Valid DadosDepartamento departamento,
		
		@NotNull @Valid DadosCadastroTelefone telefone,
		
		@NotNull @Valid DadosCadastroEmail email,
		
		@NotNull @Valid DadosCadastroEndereco endereco
		
		) {
}
