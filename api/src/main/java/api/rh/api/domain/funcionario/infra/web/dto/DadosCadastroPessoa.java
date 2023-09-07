package api.rh.api.domain.funcionario.infra.web.dto;

import java.time.LocalDate;
import api.rh.api.commun.domain.humanResource.contato.DadosCadastroTelefone;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPessoa(
					
					  @NotBlank
					  String nome,
					  
					  @NotNull
					  LocalDate nascimento,
					  
					  @NotNull
					  Sexo sexo,
					  
					  @NotNull @Valid DadosCadastroCpf cpf,
					  
					  @NotNull @Valid DadosCadastroEmail email,
					  
					  @NotNull @Valid DadosCadastroTelefone telefone) {

}
