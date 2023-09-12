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

	public void atualizarInformacoes(DadosCadastroEndereco dados) {
		
		if(dados.pais() != null) {
			this.pais = dados.pais();
		}
		if(dados.estado() != null) {
			this.estado = dados.estado();
		}
		if(dados.cidade() != null) {
			this.cidade = dados.cidade();
		}
		if(dados.rua() != null) {
			this.rua = dados.rua();
		}
		if(dados.numero() != null) {
			this.numero = dados.rua();
		}
		if(dados.cep() != null) {
			this.cep = dados.cep();
		}	
	}
}
