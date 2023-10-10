package api.rh.api.commun.domain.humanResource.contato;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Telefone {

	private String ddd;	
	private String ddi;
	private String telefone;
	
	public Telefone(DadosCadastroTelefone dados) {
		
		setDdd(dados.ddd());
		setDdi(dados.ddi());
		setTelefone(dados.telefone());
	}

	public void setDdd(String ddd) {
		if(ddd == null || !ddd.matches("\\d{2}")) {
			throw new IllegalArgumentException("ddd deve conter : 2 digitos");
		}
		this.ddd = ddd;
	}
	
	public void setDdi(String ddi) {
		if(ddi == null || !ddi.matches("\\d{3}")) {
			throw new IllegalArgumentException("ddi deve conter : 3 digitos");
		}
		this.ddi = ddi;
	}
	
	public void setTelefone(String telefone) {
		if(telefone == null || !telefone.matches("\\d{8}|\\d{9}")) {
			throw new IllegalArgumentException("Telefone deve conter 8 ou 9 digitos ");
		}
		this.telefone = telefone;
	}
	
}
