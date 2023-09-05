package api.rh.api.domain.funcionario.entity;

import java.time.LocalDate;

import api.rh.api.commun.domain.humanResource.cpf.Cpf;
import api.rh.api.domain.funcionario.infra.web.dto.Sexo;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

	private String nome;
	private LocalDate nascimento; 
	
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@Embedded
	private Cpf cpf;
}
