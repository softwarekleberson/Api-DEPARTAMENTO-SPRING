package api.rh.api.domain.cargo.entity;

import java.math.BigDecimal;

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
	private String nome;
	private String descricao;
	private BigDecimal salario_Base;
	private BigDecimal salario_Maximo;
	
	@Enumerated(EnumType.STRING)
	private NivelEstagio nivel;
	
	public Cargo(DadosCadastroCargo dados) {
		this.nome = dados.nome();
		this.descricao = dados.descricao();
		this.salario_Base = dados.salarioBase();
		this.salario_Maximo = dados.salarioMaximo();
		this.nivel = dados.nivel();
	}

	public void atualizarInformacoes(@Valid DadosAtualizarCargo dados) {
		
		if (dados.nome() != null) {
			this.nome = dados.nome();
		}
		if(dados.descricao() != null) {
			this.descricao = dados.descricao();
		}
		if(dados.salarioBase() != null) {
			this.salario_Base = dados.salarioBase();
		}
		if(dados.salarioMaximo() != null) {
			this.salario_Maximo = dados.salarioMaximo();
		}
	}
}
