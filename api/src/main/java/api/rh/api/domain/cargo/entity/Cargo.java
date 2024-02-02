package api.rh.api.domain.cargo.entity;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

import api.rh.api.domain.cargo.infra.web.dto.post.DadosCadastroCargo;
import api.rh.api.domain.cargo.infra.web.dto.post.NivelEstagio;
import api.rh.api.domain.departamento.entity.Departamento;
import api.rh.api.domain.funcionario.entity.Funcionario;
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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cargos")
@Entity(name = "Cargo")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cargo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public static final int MAXIMO_NOME_LENGTH = 100;
	private String nome;
	
	public static final int MAXIMO_DESCRICAO_LENGTH = 1000;
	private String descricao;
	
	private BigDecimal salario_Base;
	
	private BigDecimal salario_Maximo;
	
	private Boolean ativo;
	
	@Enumerated(EnumType.STRING)
	private NivelEstagio nivel;
	
	@OneToMany(mappedBy = "cargo")
	private Set<Funcionario> funcionario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "departamentos_id")
	private Departamento departamento;
	
	
	public Cargo(DadosCadastroCargo dados) {
		
		setNome(dados.nome());
		setDescricao(dados.descricao());
		setSalario_Base(dados.salarioBase());
		setSalario_Maximo(dados.salarioMaximo());
		setAtivo(true);
		setNivel(dados.nivel());
		setDepartamento(dados.idDepartamento());

	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setDepartamento(Long idDepartamento) {
		this.departamento = new Departamento();
		departamento.setId(idDepartamento);
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	public void setNome(String nome) {
		String verificaNome = Objects.requireNonNull(nome, "Nome não deve ser nulo");
		if(verificaNome.length() > MAXIMO_NOME_LENGTH) {
			throw new IllegalArgumentException("Nome não deve ser maior que : " + MAXIMO_NOME_LENGTH + " caracteres");
		}
		this.nome = nome;
	}
	
	public void setDescricao(String descricao) {
		String verificaDescricao = Objects.requireNonNull(descricao, "Descrição não deve ser nula");
		if(verificaDescricao.length() > MAXIMO_DESCRICAO_LENGTH) {
			throw new IllegalArgumentException("Descrição não deve ser maior que  : " + MAXIMO_DESCRICAO_LENGTH + " caracteres");
		}
		this.descricao = descricao;
	}
	
	public void setSalario_Base(BigDecimal salario_Base) {
		this.salario_Base = salario_Base;
	}
	
	public void setSalario_Maximo(BigDecimal salario_Maximo) {
		this.salario_Maximo = salario_Maximo;
	}
	
	public void setNivel(NivelEstagio nivel) {
		this.nivel = Objects.requireNonNull(nivel, "Nivel não deve ser nulo");
	}
}
