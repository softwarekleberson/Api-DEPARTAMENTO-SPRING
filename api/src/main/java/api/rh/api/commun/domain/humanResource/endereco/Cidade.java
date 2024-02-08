package api.rh.api.commun.domain.humanResource.endereco;

import java.util.Objects;

import api.rh.api.commun.domain.humanResource.endereco.dtos.DadosCadastroCidade;
import api.rh.api.commun.domain.humanResource.endereco.dtos.DadosCadastroEstado;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cidade {

	public static final int MENOR_COMPRIMENTO_STRING = 3;
	private String cidade;
	
	@Embedded
	private Estado estado;
	
	public Cidade(DadosCadastroCidade dados) {
		setCidade(dados.cidade());
		setEstado(dados.estado());
	}
	
	public void setCidade(String cidade) {
		String validaCidade = Objects.requireNonNull(cidade,"Cidade não deve ser nula");
		if(validaCidade.length() < MENOR_COMPRIMENTO_STRING) {
			throw new IllegalArgumentException("Cidade deve conter no minimo " + MENOR_COMPRIMENTO_STRING + " caracteres");
		}
		this.cidade = cidade;
	}
	
	public void setEstado(DadosCadastroEstado dados) {
		this.estado = new Estado(dados);
	}
	
	public void atualizarCidade(DadosCadastroCidade dados) {
		if(dados.cidade() != null) {
			setCidade(dados.cidade());
		}
	}
}
