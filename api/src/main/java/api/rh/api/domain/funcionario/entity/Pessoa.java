package api.rh.api.domain.funcionario.entity;

import java.time.LocalDate;

import api.rh.api.commun.domain.humanResource.cpf.Cpf;
import api.rh.api.domain.funcionario.infra.web.dto.post.DadosCadastroCpf;
import api.rh.api.domain.funcionario.infra.web.dto.post.DadosCadastroPessoa;
import api.rh.api.domain.funcionario.infra.web.dto.post.Sexo;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Pessoa {

	private String nome;
	private LocalDate nacimento; 
	
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@Embedded
	private Cpf cpf;

	public Pessoa(DadosCadastroPessoa dados) {
		setNome(dados.nome());
		setNacimento(dados.nacimento());
		setSexo(dados.sexo());
		setCpf(dados.cpf());
	}
	
	public void setNome(String nome) {
		this.nome = nome;
		System.out.println("nome esta aqui " + this.nome);

	}
	
	public void setNacimento(LocalDate nacimento) {
		this.nacimento = nacimento;
		System.out.println("Nacimento " + this.nacimento);
	}
	
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
		System.out.println("sexo : " + this.sexo);
	}
	
	public void setCpf(DadosCadastroCpf dados) {
		this.cpf = new Cpf(dados);
		System.out.println("cpf " + this.cpf);
	}
	
	public void atualizarInformacoesNome(String nome) {
		this.nome = nome;
	}	
}
