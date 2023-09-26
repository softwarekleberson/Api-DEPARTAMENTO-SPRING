package api.rh.api.commun.domain.humanResource.contato;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Telefone {

	public static final int TAMANHO_DDD = 2;
	private String ddd;
	
	public static final int TAMANHO_DDI = 3;
	private String ddi;
	
	public static final int TAMANHO_MAXIMO_TELEFONE = 9;
	public static final int TAMANHO_MINIMO_TELEFONE = 8;
	private String telefone;
	
	public Telefone(DadosCadastroTelefone dados) {
		
		setDdd(dados.ddd());
		setDdi(dados.ddi());
		setTelefone(dados.telefone());
	}

	public void setDdd(String ddd) {
		String validarDDD = Objects.requireNonNull(ddd,"ddd não deve ser nulo");
		if(validarDDD.length() != TAMANHO_DDD) {
			throw new IllegalArgumentException("ddd deve ter : " + TAMANHO_DDD + " caracteres");
		}
		this.ddd = ddd;
	}
	
	public void setDdi(String ddi) {
		String validarDdi = Objects.requireNonNull(ddi,"ddi não deve ser nulo");
		if(validarDdi.length() != TAMANHO_DDI) {
			throw new IllegalArgumentException("ddi deve conter : " + TAMANHO_DDI + " caracteres");
		}
		this.ddi = ddi;
	}
	
	public void setTelefone(String telefone) {
		String validarTelefone = Objects.requireNonNull(telefone,"Telefone não deve ser nulo");
		if(!(validarTelefone.length() == TAMANHO_MAXIMO_TELEFONE) || (validarTelefone.length() == TAMANHO_MINIMO_TELEFONE)) {
			throw new IllegalArgumentException("Telefone deve conter : " + TAMANHO_MAXIMO_TELEFONE + " ou " + TAMANHO_MINIMO_TELEFONE + " caracteres");
		}
		this.telefone = telefone;
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
