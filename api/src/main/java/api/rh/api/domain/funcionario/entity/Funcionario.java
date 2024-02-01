package api.rh.api.domain.funcionario.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import api.rh.api.commun.domain.humanResource.contato.DadosCadastroTelefone;
import api.rh.api.commun.domain.humanResource.contato.Email;
import api.rh.api.commun.domain.humanResource.contato.Telefone;
import api.rh.api.domain.cargo.entity.Cargo;
import api.rh.api.domain.funcionario.infra.web.dto.post.DadosCadastroEmail;
import api.rh.api.domain.funcionario.infra.web.dto.post.DadosCadastroFuncionarios;
import api.rh.api.domain.funcionario.infra.web.dto.post.Profissao;
import api.rh.api.domain.reajusteSalarialNivelProfissional.entity.ReajusteSalarioCargo;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
public class Funcionario extends Pessoa {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate contratacao;
	
	private BigDecimal salario;
	
	@Embedded
	private Email email;
	
	@Embedded
	private Telefone telefone;
	
	@Enumerated(EnumType.STRING)
	private Profissao profissao;
	
	private Boolean ativo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cargos_id")
	private Cargo cargo;
	
	@OneToMany(mappedBy = "funcionario")
	private Set<ReajusteSalarioCargo> reajuste;
	
	 public Funcionario(DadosCadastroFuncionarios dados) {
		 
		 super(dados.funcionario().pessoa());
		 setAtivo(true);
		 setContratacao(dados.funcionario().contratacao());
		 setSalario(dados.funcionario().salario());
		 setEmail(dados.funcionario().email());
		 setTelefone(dados.funcionario().telefone());
		 setProfissao(dados.funcionario().profissao());
		 setCargo(dados.idCargo());
	 }
	 
	public void setId(Long id) {
		this.id = id;
	}
	 
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	 
	public void setCargo(Long idCargo) {
		this.cargo = new Cargo();
		cargo.setId(idCargo);
	}
	
	public void setContratacao(LocalDate contratacao) {
		this.contratacao = contratacao;
	}
	
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	
	public void setProfissao(Profissao profissao) {
		String validarProfissao = Objects.requireNonNull("Profissão não deve ser nulo");
		this.profissao = profissao;
	}
	
	public void setEmail(DadosCadastroEmail dados) {
		this.email = new Email(dados);
	}
	
	public void setTelefone(DadosCadastroTelefone dados) {
		if(dados != null) {
			this.telefone = new Telefone(dados);
		}
	}
}
