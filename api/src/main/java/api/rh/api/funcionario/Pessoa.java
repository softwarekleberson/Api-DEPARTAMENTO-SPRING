package api.rh.api.funcionario;

import java.time.LocalDate;

import api.rh.api.contato.Email;
import api.rh.api.contato.Telefone;

public record Pessoa(String nome, LocalDate nascimento,
					  Sexo sexo, Cpf cpf,
					  Email email, Telefone telefone) {

}
