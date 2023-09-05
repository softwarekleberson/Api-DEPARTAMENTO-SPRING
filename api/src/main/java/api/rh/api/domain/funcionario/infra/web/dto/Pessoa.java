package api.rh.api.domain.funcionario.infra.web.dto;

import java.time.LocalDate;

import api.rh.api.commun.domain.humanResource.contato.Email;
import api.rh.api.commun.domain.humanResource.contato.Telefone;
import api.rh.api.commun.domain.humanResource.cpf.Cpf;


public record Pessoa(String nome, LocalDate nascimento,
					  Sexo sexo, Cpf cpf,
					  Email email, Telefone telefone) {

}
