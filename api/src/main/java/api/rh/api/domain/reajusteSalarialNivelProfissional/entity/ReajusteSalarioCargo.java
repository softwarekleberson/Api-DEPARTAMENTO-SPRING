package api.rh.api.domain.reajusteSalarialNivelProfissional.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import api.rh.api.domain.funcionario.entity.Funcionario;
import api.rh.api.domain.reajusteSalarialNivelProfissional.infra.web.dto.post.DadosCadastroReajusteSalarioal;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

@Table(name = "reajustes")
@Entity(name = "ReajusteSalarioCargo")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ReajusteSalarioCargo {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate diaReajuste;
	
	private BigDecimal valorReajuste;
	
	private String motivoPromocao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;
	
	public ReajusteSalarioCargo(DadosCadastroReajusteSalarioal dados) {
		setDiaReajuste(LocalDate.now());
		setValorReajuste(dados.novoSalario());
		setFuncionario(dados.idFuncionario());
	}
	
	public void setFuncionario(Long idFuncionario) {
		this.funcionario = new Funcionario();
		funcionario.setId(idFuncionario);
	}
	
	public void setDiaReajuste(LocalDate diaReajuste) {
		this.diaReajuste = diaReajuste;
	}
	
	public void setValorReajuste(BigDecimal valorReajuste) {
		this.valorReajuste = valorReajuste;
	}
	
}
