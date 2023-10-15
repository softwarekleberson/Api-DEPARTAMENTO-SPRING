package api.rh.api.domain.projetos.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;


import api.rh.api.domain.departamento.entity.Departamento;
import api.rh.api.domain.projetos.infra.web.dto.post.DadosCadastroProjeto;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "projetos")
@Entity(name = "Projeto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Projeto {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private boolean ativo;
	
	private String nome;
	
	private String descricao;
	
	private BigDecimal custoProjeto;
	
	private LocalDate inicioProjeto;
	
	private LocalDate tempoTerminarProjeto;
	
	@Enumerated(EnumType.STRING)
	private SatatusProjeto statusProjeto;
	
	@ManyToOne
	@JoinColumn(name = "departamento_id")
	private Departamento departamento;
	
	public Projeto(DadosCadastroProjeto dados) {
		
		setNome(dados.nome());
		setAtivo(true);
		setDescricao(dados.descricao());
		setCustoProjeto(dados.custo());
		setInicioProjeto(LocalDate.now());
		setTempoTerminarProjeto(dados.terminoProjeto());
	}
	
	public void setNome(String nome) {
		String nomeValidar = Objects.requireNonNull(nome,"Nome não deve ser nulo");
		this.nome = nome;
	}
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public void setDescricao(String descricao) {
		String descricaoValidar = Objects.requireNonNull(descricao,"Descrição não deve ser nulo");
		this.descricao = descricao;
	}
	
	public void setCustoProjeto(BigDecimal custoProjeto) {
		if(custoProjeto.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Custo do projeto não deve ser menor que 0");
		}
		this.custoProjeto = custoProjeto;
	}
	
	public void setStatusProjeto(SatatusProjeto statusProjeto) {
		this.statusProjeto = statusProjeto;
	}
	
	
	public void setInicioProjeto(LocalDate inicioProjeto) {
		this.inicioProjeto = inicioProjeto;
	}
	
	public void setTempoTerminarProjeto(LocalDate tempoTerminarProjeto) {
		this.tempoTerminarProjeto = tempoTerminarProjeto;
	}
}
