package api.rh.api.domain.departamento.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import api.rh.api.domain.departamento.infra.web.dto.post.DadosCadastroOrcamento;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class OrcamentoDepartamento {

	private LocalDate ano;
	
	private BigDecimal orcamento;
	
	private BigDecimal saldo;
	
	public OrcamentoDepartamento(DadosCadastroOrcamento dados) {
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
