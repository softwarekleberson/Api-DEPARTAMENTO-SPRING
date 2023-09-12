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
		this.ddd = dados.ddd();
		this.ddi = dados.ddi();
		this.telefone = dados.telefone();
	}

	

	public void atualizatTelefone(DadosCadastroTelefone dados) {
		if(dados.ddd() != null) {
			this.ddd = dados.ddd();
		}
		
		if(dados.ddi() != null) {
			this.ddi = dados.ddi();
		}
		
		if(dados.telefone() != null) {
			this.telefone = dados.telefone();
		}
		
	}
	
}
