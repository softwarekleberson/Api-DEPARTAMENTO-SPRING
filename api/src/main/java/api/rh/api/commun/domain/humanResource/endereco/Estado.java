package api.rh.api.commun.domain.humanResource.endereco;

import java.util.Objects;

import api.rh.api.commun.domain.humanResource.endereco.dtos.DadosCadastroEstado;
import api.rh.api.commun.domain.humanResource.endereco.dtos.DadosCadastroPais;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Estado {

	public static final int MENOR_COMPRIMENTO_STRING = 3;
	
	private String estado;
	
	@Embedded
	private Pais pais;
	
	public Estado(DadosCadastroEstado dados) {
		setEstado(dados.estado());
		setPais(dados.pais());
	}
	
	public void setEstado(String estado) {
		String validaEstado = Objects.requireNonNull(estado,"Estado não deve ser nulo");
		if(validaEstado.length() < MENOR_COMPRIMENTO_STRING) {
			throw new IllegalArgumentException("Estado deve conter no minimo : " + MENOR_COMPRIMENTO_STRING + " caracteres");
		}
		this.estado = estado;
	}
	
	public void setPais(DadosCadastroPais dados) {
		this.pais = new Pais(dados);
	}
	
	public void atualizarEstado(DadosCadastroEstado dados) {
		if(dados.estado() != null) {
			setEstado(dados.estado());
		}
	}
}
