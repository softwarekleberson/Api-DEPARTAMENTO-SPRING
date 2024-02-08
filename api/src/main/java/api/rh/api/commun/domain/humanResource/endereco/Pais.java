package api.rh.api.commun.domain.humanResource.endereco;

import java.util.Objects;

import api.rh.api.commun.domain.humanResource.endereco.dtos.DadosCadastroPais;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Pais {

	public static final int MENOR_STRING_PAIS_LENGT = 4;
	private String pais;
	
	public Pais(DadosCadastroPais dados) {
		setPais(dados.pais());
	}
	
	public void setPais(String pais) {
		String validaPais = Objects.requireNonNull(pais,"Pais não deve ser nulo");
		if(validaPais.length() < MENOR_STRING_PAIS_LENGT) {
			throw new IllegalArgumentException("Pais deve conter no minimo : " + MENOR_STRING_PAIS_LENGT + " caracteres");
		}
		this.pais = pais;
	}
	
	public void atualizarPais(DadosCadastroPais dados) {
		if(dados.pais() != null) {
			setPais(dados.pais());
		}
	}
}
