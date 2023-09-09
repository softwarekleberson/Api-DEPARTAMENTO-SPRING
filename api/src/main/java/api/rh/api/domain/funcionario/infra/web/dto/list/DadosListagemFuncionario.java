package api.rh.api.domain.funcionario.infra.web.dto.list;

import java.math.BigDecimal;
import java.time.LocalDate;

import api.rh.api.commun.domain.humanResource.contato.Email;
import api.rh.api.domain.funcionario.entity.Funcionario;
import api.rh.api.domain.funcionario.infra.web.dto.post.Profissao;

public record DadosListagemFuncionario(
		
		Long id,
		String nome,
		LocalDate cotratacao,
		BigDecimal salario,
		Profissao profssao,
		Email email
		
		) {

	public DadosListagemFuncionario(Funcionario funcionario) {
		this(funcionario.getId() ,funcionario.getPessoa().getNome(),
				funcionario.getContratacao(),
				funcionario.getSalario(),
				funcionario.getProfissao(),
				funcionario.getPessoa().getEmail()
		);
	}
}
