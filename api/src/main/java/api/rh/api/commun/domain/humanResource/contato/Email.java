package api.rh.api.commun.domain.humanResource.contato;

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
	
	public Email(Email dados) {
		this.email = dados.email;
	}
	
}
