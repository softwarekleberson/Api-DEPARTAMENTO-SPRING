package api.rh.api.commun.domain.humanResource.contato;

import java.util.regex.Pattern;

import api.rh.api.domain.funcionario.infra.web.dto.post.DadosCadastroEmail;
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
		setEmail(dados.email());
	}
	
	public void setEmail(String email) {
		String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
	      if (!Pattern.matches(regex, email)) {
	    	  throw new IllegalArgumentException("O endereço de e-mail fornecido"
	    	  								   + " é inválido. Por favor, verifique"
	    	  								   + " e tente novamente.");
	      }
		this.email = email;
	}
		
}
