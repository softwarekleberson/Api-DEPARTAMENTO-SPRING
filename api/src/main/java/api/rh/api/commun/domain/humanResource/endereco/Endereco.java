package api.rh.api.commun.domain.humanResource.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

	private String pais;
	private String estado;
	private String cidade;
	private String rua;
	private String numero;
	private String cep;
	
	public Endereco(DadosCadastroEndereco dados) {
		this.pais = dados.pais();
		this.estado = dados.estado();
		this.cidade = dados.cidade();
		this.rua = dados.rua();
		this.numero = dados.numero();
		this.cep = dados.cep();
	}
}
