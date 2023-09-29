package api.rh.api.commun.domain.humanResource.endereco;

import java.util.Objects;

import api.rh.api.domain.departamento.entity.Departamento;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

	public static final int MENOR_STRING_PAIS_LENGT = 4;
	private String pais;
	
	public static final int MENOR_COMPRIMENTO_STRING = 3;
	private String estado;
	private String cidade;
	private String rua;
	private String complemento;
	private String numero;
	private String cep;
	
	public Endereco(DadosCadastroEndereco dados) {
		
		setPais(dados.pais());
		setEstado(dados.estado());
		setCidade(dados.cidade());
		setRua(dados.rua());
		setNumero(dados.numero());
		setCep(dados.cep());
		setComplemento(dados.complemento());
	}

	public void setPais(String pais) {
		String validaPais = Objects.requireNonNull(pais,"Pais não deve ser nulo");
		if(validaPais.length() < MENOR_STRING_PAIS_LENGT) {
			throw new IllegalArgumentException("Pais deve conter no minimo : " + MENOR_STRING_PAIS_LENGT + " caracteres");
		}
		this.pais = pais;
	}
	
	public void setComplemento(String complemento) {
		if(complemento == null) {
			this.complemento = null;
		}
		this.complemento = complemento;
	}
	
	public void setEstado(String estado) {
		String validaEstado = Objects.requireNonNull(estado,"Estado não deve ser nulo");
		if(validaEstado.length() < MENOR_COMPRIMENTO_STRING) {
			throw new IllegalArgumentException("Estado deve conter no minimo " + MENOR_COMPRIMENTO_STRING + " caracteres");
		}
		this.estado = estado;
	}
	
	public void setCidade(String cidade) {
		String validaCidade = Objects.requireNonNull(cidade,"Cidade não deve ser nula");
		if(validaCidade.length() < MENOR_COMPRIMENTO_STRING) {
			throw new IllegalArgumentException("Cidade deve conter no minimo " + MENOR_COMPRIMENTO_STRING + " caracteres");
		}
		this.cidade = cidade;
	}
	
	public void setRua(String rua) {
		String validaRua = Objects.requireNonNull(rua,"Rua não deve ser nula");
		if(validaRua.length() < MENOR_COMPRIMENTO_STRING) {
			throw new IllegalArgumentException("Rua deve conter no minimo " + MENOR_COMPRIMENTO_STRING + " caracteres");
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
		
		if(dados.pais() != null) {
			setPais(dados.pais());
		}
		if(dados.estado() != null) {
			setEstado(dados.estado());
		}
		if(dados.cidade() != null) {
			setCidade(dados.cidade());
		}
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
