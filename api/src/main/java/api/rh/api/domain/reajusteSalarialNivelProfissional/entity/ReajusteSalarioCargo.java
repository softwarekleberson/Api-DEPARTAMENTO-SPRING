package api.rh.api.domain.reajusteSalarialNivelProfissional.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import api.rh.api.domain.funcionario.entity.Funcionario;
import api.rh.api.domain.reajusteSalarialNivelProfissional.infra.web.dto.post.DadosCadastroReajusteSalarioal;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "reajustes")
@Entity(name = "ReajusteSalarioCargo")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ReajusteSalarioCargo {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate diaReajuste;
	
	private BigDecimal valorReajuste;
	
	private Funcionario funcionario;
	
	public ReajusteSalarioCargo(DadosCadastroReajusteSalarioal dados) {
		setDiaReajuste(dados.diaAtualizacao());
		setValorReajuste(dados.novoSalario());
	}
	
	public void setDiaReajuste(LocalDate diaReajuste) {
		this.diaReajuste = diaReajuste;
	}
	
	public void setValorReajuste(BigDecimal valorReajuste) {
		this.valorReajuste = valorReajuste;
	}
	
	
}
