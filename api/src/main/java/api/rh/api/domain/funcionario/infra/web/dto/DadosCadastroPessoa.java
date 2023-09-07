package api.rh.api.domain.funcionario.infra.web.dto;

import java.time.LocalDate;
import api.rh.api.commun.domain.humanResource.contato.DadosCadastroTelefone;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPessoa(
					
					  @NotBlank(message = "Nome não pode ser nulo ou vazio")
					  String nome,
					  
					  LocalDate nascimento,
					  
					  @NotNull(message = "Sexo : M ou F")
					  Sexo sexo,
					  
					  @NotNull @Valid DadosCadastroCpf cpf,
					  
					  @NotNull @Valid DadosCadastroEmail email,
					  
					  @NotNull @Valid DadosCadastroTelefone telefone) {

}
