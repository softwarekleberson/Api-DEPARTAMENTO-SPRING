package api.rh.api.domain.departamento.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import api.rh.api.domain.departamento.infra.web.dto.post.DadosCadastroOrcamento;
import api.rh.api.domain.projetos.entity.Projeto;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Orcamento {

	private LocalDate ano;
	
	private BigDecimal orcamento;
	
	private BigDecimal saldo;
	
	public Orcamento(DadosCadastroOrcamento dados) {
		setAno(dados.ano());
		setOrcamento(dados.orcamento());
		saldoInicial();
	}
	
	public void setAno(LocalDate ano) {
		this.ano = ano;
	}
	
	public void setOrcamento(BigDecimal orcamento) {
		this.orcamento = orcamento;
	}
	
	public void saldoInicial() {
		this.saldo = getOrcamento();
	}
}
