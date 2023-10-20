package api.rh.api.domain.departamento.infra.web.dto.post;

import api.rh.api.commun.domain.humanResource.contato.DadosCadastroTelefone;
import api.rh.api.commun.domain.humanResource.endereco.DadosCadastroEndereco;
import api.rh.api.domain.funcionario.infra.web.dto.post.DadosCadastroEmail;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroDepartamento(
		
		@NotNull @Valid DadosDepartamento departamento,
		
		@NotNull @Valid DadosCadastroTelefone telefone,
		
		@NotNull @Valid DadosCadastroEmail email,
		
		@NotNull @Valid DadosCadastroEndereco endereco,
		
		@NotNull @Valid DadosCadastroOrcamento orcamento
		
		) {
}
