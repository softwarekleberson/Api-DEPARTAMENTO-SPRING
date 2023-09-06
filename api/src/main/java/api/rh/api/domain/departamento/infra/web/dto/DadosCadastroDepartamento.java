package api.rh.api.domain.departamento.infra.web.dto;

import api.rh.api.commun.domain.humanResource.contato.DadosCadastroTelefone;
import api.rh.api.commun.domain.humanResource.endereco.DadosCadastroEndereco;
import api.rh.api.domain.funcionario.infra.web.dto.DadosCadastroEmail;

public record DadosCadastroDepartamento(DadosDepartamento departamento,
		DadosCadastroTelefone telefone, DadosCadastroEmail email,
		DadosCadastroEndereco endereco
		) {
}
