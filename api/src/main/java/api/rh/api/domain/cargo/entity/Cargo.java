package api.rh.api.domain.cargo.entity;

import java.math.BigDecimal;

import api.rh.api.domain.cargo.infra.web.dto.DadosCadastroCargo;
import api.rh.api.domain.cargo.infra.web.dto.NivelEstagio;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
	private BigDecimal salarioBase;
	private BigDecimal salarioMaximo;
	
	@Enumerated(EnumType.STRING)
	private NivelEstagio nivel;
	
	public Cargo(DadosCadastroCargo dados) {
		this.nome = dados.nome();
		this.descricao = dados.descricao();
		this.salarioBase = dados.salarioBase();
		this.salarioMaximo = dados.salarioMaximo();
	}
}
