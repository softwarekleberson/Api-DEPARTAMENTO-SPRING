package api.rh.api.domain.funcionario.infra.web.dto;

import java.time.LocalDate;
import api.rh.api.commun.domain.humanResource.contato.DadosCadastroTelefone;

public record DadosCadastroPessoa(String nome, LocalDate nascimento,
					  Sexo sexo, DadosCadastroCpf cpf,
					  DadosCadastroEmail email, DadosCadastroTelefone telefone) {

}
