package api.rh.api.domain.cargo.entity;

import java.math.BigDecimal;
import java.util.Objects;

import api.rh.api.domain.cargo.infra.web.dto.post.DadosCadastroCargo;
import api.rh.api.domain.cargo.infra.web.dto.post.NivelEstagio;
import api.rh.api.domain.cargo.infra.web.dto.put.DadosAtualizarCargo;
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

@Table(name = "cargos")
@Entity(name = "Cargo")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cargo {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public static final int MAXIMO_NOME_LENGTH = 100;
	private String nome;
	
	public static final int MAXIMO_DESCRICAO_LENGTH = 1000;
	private String descricao;
	
	public static final BigDecimal SALARIO_MINIMO = new BigDecimal("1320");
	private BigDecimal salario_Base;
	
	public static final BigDecimal SALARIO_MAXIMO = new BigDecimal("18000");
	private BigDecimal salario_Maximo;
	
	@Enumerated(EnumType.STRING)
	private NivelEstagio nivel;
	
	private Boolean ativo;
	
	public Cargo(DadosCadastroCargo dados) {

		setAtivo(true);
		setNome(dados.nome());
		setDescricao(dados.descricao());
		setSalario_Base(dados.salarioBase());
		setSalario_Maximo(dados.salarioMaximo());
		setNivel(dados.nivel());
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
		if(SALARIO_MINIMO.compareTo(salario_Base) > 0) {
			throw new IllegalArgumentException("Salário mínimo menor do que o piso");
		}
		this.salario_Base = salario_Base;
	}
	
	public void setSalario_Maximo(BigDecimal salario_Maximo) {
		if(salario_Maximo.compareTo(SALARIO_MAXIMO) > 0) {
			throw new IllegalArgumentException("O salário máximo não deve ser maior do que : " + SALARIO_MAXIMO);
		}
		this.salario_Maximo = salario_Maximo;
	}
	
	public void setNivel(NivelEstagio nivel) {
		this.nivel = Objects.requireNonNull(nivel, "Nivel não deve ser nulo");
	}
}
