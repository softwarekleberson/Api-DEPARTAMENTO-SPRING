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
		this.cpf = dados.cpf();
	}
	
	
}
