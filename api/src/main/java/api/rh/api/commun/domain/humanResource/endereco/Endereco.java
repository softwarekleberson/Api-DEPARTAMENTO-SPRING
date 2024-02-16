package api.rh.api.commun.domain.humanResource.endereco;

import java.util.Objects;

import api.rh.api.commun.domain.humanResource.endereco.dtos.DadosCadastroCidade;
import api.rh.api.commun.domain.humanResource.endereco.dtos.DadosCadastroEndereco;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
	
	public static final int MENOR_COMPRIMENTO_STRING = 3;
	private String rua;
	private String complemento;
	private String numero;
	private String cep;
	
	@Embedded
	private Cidade cidade;
	
	public Endereco(DadosCadastroEndereco dados) {
		
		setRua(dados.rua());
		setNumero(dados.numero());
		setCep(dados.cep());
		setComplemento(dados.complemento());
		setCidade(dados.cidade());
	}
	
	public void setCidade(DadosCadastroCidade dados) {
		this.cidade = new Cidade(dados);
	}
	
	public void setComplemento(String complemento) {
		if(complemento == null) {
			this.complemento = null;
		}
		this.complemento = complemento;
	}
	
	public void setRua(String rua) {
		String validaRua = Objects.requireNonNull(rua,"Rua não deve ser nula");
		if(validaRua.length() < MENOR_COMPRIMENTO_STRING) {
			throw new IllegalArgumentException("Rua deve conter no minimo : " + MENOR_COMPRIMENTO_STRING + " caracteres");
		}
		this.rua = rua;
	}
	
	public void setNumero(String numero) {
		if(numero == null) {
			this.numero = null;
		}
		this.numero = numero;
	}
	
	public void setCep(String cep) {
        String padrao = "\\d{5}|\\d{8}|\\d{9}";
        if(!cep.matches(padrao)) {
        	throw new IllegalArgumentException("Cep deve conter 5, 8 ou 9 digitos");
        }
		this.cep = cep;
	}
	
	public void atualizarEndereco(DadosCadastroEndereco dados) {
		
		if(dados.rua() != null) {
			setRua(dados.rua());
		}
		if(dados.numero() != null) {
			setNumero(dados.numero());
		}
		if(dados.complemento() != null) {
			setComplemento(dados.complemento());
		}
		if(dados.cep() != null) {
			setCep(dados.cep());
		}			
	}
}
