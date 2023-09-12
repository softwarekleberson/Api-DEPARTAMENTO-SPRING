package api.rh.api.domain.departamento.infra.web.dto.put;

import api.rh.api.commun.domain.humanResource.contato.DadosCadastroTelefone;
import api.rh.api.commun.domain.humanResource.endereco.DadosCadastroEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarDepartamento(
		
		@NotNull
		Long id,
		
		String nome,
		String descricao,
		
		DadosCadastroTelefone telefone,
		DadosCadastroEndereco endereco
			
		) {

}
