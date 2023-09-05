package api.rh.api.domain.departamento.infra.web.dto;

import api.rh.api.commun.domain.humanResource.contato.Email;
import api.rh.api.commun.domain.humanResource.contato.Telefone;
import api.rh.api.commun.domain.humanResource.endereco.Endereco;

public record DadosCadastroDepartamento(Departamento departamento,
		Telefone telefone, Email email,
		Endereco endereco
		) {
}
