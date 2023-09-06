package api.rh.api.commun.domain.humanResource.contato;

import api.rh.api.domain.funcionario.infra.web.dto.DadosCadastroEmail;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Email {

	private String email;
	
	public Email(DadosCadastroEmail dados) {
		this.email = dados.email();
	}
		
}
