package api.rh.api.departamento;

import api.rh.api.contato.Email;
import api.rh.api.contato.Telefone;
import api.rh.api.endereco.Endereco;

public record DadosCadastroDepartamento(Departamento departamento,
		Telefone telefone, Email email,
		Endereco endereco
		) {
}
