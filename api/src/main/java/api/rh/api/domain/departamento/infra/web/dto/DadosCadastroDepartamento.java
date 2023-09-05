package api.rh.api.domain.departamento.infra.web.dto;

import api.rh.api.commun.domain.humanResource.contato.Email;
import api.rh.api.commun.domain.humanResource.contato.DadosCadastroTelefone;
import api.rh.api.commun.domain.humanResource.endereco.DadosCadastroEndereco;

public record DadosCadastroDepartamento(DadosDepartamento departamento,
		DadosCadastroTelefone telefone, Email email,
		DadosCadastroEndereco endereco
		) {
}
