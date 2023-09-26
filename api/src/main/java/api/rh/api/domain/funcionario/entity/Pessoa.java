package api.rh.api.domain.funcionario.entity;

import java.time.LocalDate;

import api.rh.api.commun.domain.humanResource.contato.DadosCadastroTelefone;
import api.rh.api.commun.domain.humanResource.contato.Email;
import api.rh.api.commun.domain.humanResource.contato.Telefone;
import api.rh.api.commun.domain.humanResource.cpf.Cpf;
import api.rh.api.domain.funcionario.infra.web.dto.post.DadosCadastroCpf;
import api.rh.api.domain.funcionario.infra.web.dto.post.DadosCadastroEmail;
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
		setNome(dados.nome());
		setNascimento(dados.nascimento());
		setSexo(dados.sexo());
		setCpf(dados.cpf());
		setEmail(dados.email());
		setTelefone(dados.telefone());
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	public void setCpf(DadosCadastroCpf dados) {
		this.cpf = new Cpf(dados);
	}
	
	public void setEmail(DadosCadastroEmail dados) {
		this.email = new Email(dados);
	}
	
	public void setTelefone(DadosCadastroTelefone dados) {
		this.telefone = new Telefone(dados);
	}
	
	public void atualizarInformacoesNome(String nome) {
		this.nome = nome;
	}

	
}
