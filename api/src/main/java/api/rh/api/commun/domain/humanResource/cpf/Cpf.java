package api.rh.api.commun.domain.humanResource.cpf;

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
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Cpf [cpf=" + cpf + "]";
	}
	
}
