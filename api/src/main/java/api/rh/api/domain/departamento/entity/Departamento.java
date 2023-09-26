package api.rh.api.domain.departamento.entity;

import java.time.LocalDate;
import java.util.Objects;

import api.rh.api.commun.domain.humanResource.contato.DadosCadastroTelefone;
import api.rh.api.commun.domain.humanResource.contato.Email;
import api.rh.api.commun.domain.humanResource.contato.Telefone;
import api.rh.api.commun.domain.humanResource.endereco.DadosCadastroEndereco;
import api.rh.api.commun.domain.humanResource.endereco.Endereco;
import api.rh.api.domain.departamento.infra.web.dto.post.DadosCadastroDepartamento;
import api.rh.api.domain.departamento.infra.web.dto.put.DadosAtualizarDepartamento;
import api.rh.api.domain.funcionario.infra.web.dto.post.DadosCadastroEmail;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "departamentos")
@Entity(name = "Departamento")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Departamento {

	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private Boolean ativo;
	
	public static final int MAXIMO_NOME_LENGTH = 100;
    private String nome;
    
    public static final int MAXIMO_DESCRICAO_LENGTH = 1000;
    private String descricao;
    
    @Embedded
    private Telefone telefone;
    
    @Embedded
    private Email email;
    
    @Embedded
    private Endereco endereco;
    
    private LocalDate criacao;
    
   
    public Departamento(DadosCadastroDepartamento dados) {
    	
    	setAtivo(ativo);
    	setNome(dados.departamento().nome());
    	setDescricao(dados.departamento().descricao());
    	setTelefone(dados.telefone());
    	setEmail(dados.email());
    	setEndereco(dados.endereco());
    	setCriacao(dados.departamento().criacao());
    
    }
    
    public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
    
    public void setNome(String nome) {
    	String validarNome = Objects.requireNonNull(nome,"Nome não deve ser nulo");
    	if(validarNome.length() > MAXIMO_NOME_LENGTH) {
    		throw new IllegalArgumentException("Nome não deve ser maior que : " + MAXIMO_NOME_LENGTH + " caracteres");
    	}
		this.nome = nome;
	}
    
    public void setDescricao(String descricao) {
    	String validarDescricao = Objects.requireNonNull(descricao,"Descricão não deve ser nulo");
    	if(validarDescricao.length() > MAXIMO_DESCRICAO_LENGTH) {
    		throw new IllegalArgumentException("Descrição não deve ser maior que : " + MAXIMO_DESCRICAO_LENGTH + " caracteres");
    	}
		this.descricao = descricao;
	}
    
    public void setCriacao(LocalDate criacao) {
    	System.out.println(criacao);
		this.criacao = criacao;
	}
    
    public void setTelefone(DadosCadastroTelefone dadosCadastroTelefone) {
    	this.telefone = new Telefone(dadosCadastroTelefone);
	}
    
    public void setEmail(DadosCadastroEmail dados) {
		this.email = new Email(dados.email());
	}
    
    public void setEndereco(DadosCadastroEndereco dados) {
		this.endereco = new Endereco(dados);
	}
    

	public void atualizarInformacoes(@Valid DadosAtualizarDepartamento dados) {
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
		if(dados.descricao() != null) {
			this.descricao = dados.descricao();
		}
		if(dados.telefone() != null) {
			this.telefone.atualizatTelefone(dados.telefone());
		}
		if(dados.endereco() != null) {
			this.endereco.atualizarInformacoes(dados.endereco());
		}
			
	}

	public void excluir() {
		this.ativo = false;
	}
}
