package api.rh.api.domain.reajusteSalarialNivelProfissional.infra.web.dto.post;

import java.math.BigDecimal;

import api.rh.api.domain.funcionario.infra.web.dto.post.DadosCadastroCpf;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroReajusteSalarioal(
		
		@NotNull
		Long idFuncionario,
		
		@NotNull
		DadosCadastroCpf cpf,
		
		@NotNull
		BigDecimal novoSalario,	
		
		@NotNull
		String motivoReajuste
		
										   ) {

}
