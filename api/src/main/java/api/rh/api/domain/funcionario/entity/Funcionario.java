package api.rh.api.domain.funcionario.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import api.rh.api.domain.funcionario.infra.web.dto.post.DadosCadastroFuncionarios;
import api.rh.api.domain.funcionario.infra.web.dto.post.DadosCadastroPessoa;
import api.rh.api.domain.funcionario.infra.web.dto.post.Profissao;
import api.rh.api.domain.funcionario.infra.web.dto.put.DadosAtualizarFuncionario;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "funcionarios")
@Entity(name = "Funcionario")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Funcionario {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate contratacao;
	
	public static final BigDecimal VALIDACAO_SALARIO_FUNCIONARIO = new BigDecimal("1320");
	private BigDecimal salario;
	
	@Embedded
	private Pessoa pessoa;
	
	@Enumerated(EnumType.STRING)
	private Profissao profissao;
	
	private Boolean ativo;
	
	 public Funcionario(DadosCadastroFuncionarios dados) {
		 this.ativo = true;
		 
		 setContratacao(dados.funcionario().contratacao());
		 setSalario(dados.funcionario().salario());
		 setPessoa(dados.funcionario().pessoa());
		 setProfissao(dados.profissao());
	 }
	 
	public void setContratacao(LocalDate contratacao) {
		this.contratacao = contratacao;
	}
	
	public void setSalario(BigDecimal salario) {
		if(VALIDACAO_SALARIO_FUNCIONARIO.compareTo(salario) > 0) {
			throw new IllegalArgumentException("Salario abaixo do minimo");
		}
		this.salario = salario;
	}
	
	public void setPessoa(DadosCadastroPessoa dados) {
		this.pessoa = new Pessoa(dados);
	}
	
	public void setProfissao(Profissao profissao) {
		String validarProsissao = Objects.requireNonNull("Profissão não deve ser nulo");
		this.profissao = profissao;
	}

	public void atualizarInfomacoes(@Valid DadosAtualizarFuncionario dados) {
		if(dados.nome() != null) {
			this.getPessoa().atualizarInformacoesNome(dados.nome());
		}
		
		if(dados.telefone() != null) {
			this.getPessoa().getTelefone().atualizatTelefone(dados.telefone());
		}	
	}

	public void excluir() {
		this.ativo = false;
	}
}
