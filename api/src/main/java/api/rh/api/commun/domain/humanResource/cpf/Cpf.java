package api.rh.api.commun.domain.humanResource.cpf;

import java.util.Objects;

import api.rh.api.domain.funcionario.infra.web.dto.post.DadosCadastroCpf;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cpf {

	private String cpf;
	
	public Cpf(DadosCadastroCpf  dados) {
		setCpf(dados.cpf());
	}
	
	public void setCpf(String cpf) {
		
		String tempNumber = Objects.requireNonNull(cpf, "O cpf não pode ser nulo");
		
		CpfValidacao cpfValido = ServiceLocator.getCpfValidator();

		if (cpfValido.isValid(tempNumber)) {
			this.cpf = tempNumber.replace("[^\\d]", "");

		} else {
			throw new IllegalArgumentException("O cpf é invalido.");
		}
	}
	
	@Override
	public String toString() {
		return "Cpf [cpf=" + cpf + "]";
	}
	
}
