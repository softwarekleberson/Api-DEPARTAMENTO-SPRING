package api.rh.api.domain.funcionario.entity;

import java.time.LocalDate;

import api.rh.api.commun.domain.humanResource.contato.Email;
import api.rh.api.commun.domain.humanResource.contato.Telefone;
import api.rh.api.commun.domain.humanResource.cpf.Cpf;
import api.rh.api.domain.funcionario.infra.web.dto.post.DadosCadastroPessoa;
import api.rh.api.domain.funcionario.infra.web.dto.post.Sexo;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

	private String nome;
	private LocalDate nascimento; 
	
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@Embedded
	private Cpf cpf;
	
	@Embedded
	private Email email;
	
	@Embedded
	private Telefone telefone;
	
	public Pessoa(DadosCadastroPessoa dados) {
		this.nome = dados.nome();
		this.nascimento = dados.nascimento();
		this.sexo = dados.sexo();
		this.cpf = new Cpf(dados.cpf());
		this.email = new Email(dados.email());
		this.telefone = new Telefone(dados.telefone());	
	}

	public void atualizarInformacoesNome(String nome) {
		this.nome = nome;
	}

	
}
