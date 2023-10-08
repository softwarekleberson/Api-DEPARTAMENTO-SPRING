package api.rh.api.domain.funcionario.infra.web.dto.put;

import java.math.BigDecimal;
import java.time.LocalDate;

import api.rh.api.commun.domain.humanResource.contato.Email;
import api.rh.api.commun.domain.humanResource.contato.Telefone;
import api.rh.api.commun.domain.humanResource.cpf.Cpf;
import api.rh.api.domain.funcionario.entity.Funcionario;
import api.rh.api.domain.funcionario.entity.Pessoa;
import api.rh.api.domain.funcionario.infra.web.dto.post.Profissao;
import api.rh.api.domain.funcionario.infra.web.dto.post.Sexo;

public record DadosDetalhamentoFuncionario(Long id, LocalDate contratacao,
		BigDecimal salario, String nome,
		LocalDate nascimento, Sexo sexo,
		Cpf cpf, Email email,
		Telefone telefone, Profissao profissao) {

	public DadosDetalhamentoFuncionario(Funcionario funcionarios) {
		this(funcionarios.getId(), funcionarios.getContratacao(),
			funcionarios.getSalario(), funcionarios.getNome(),
			funcionarios.getNacimento(),
			funcionarios.getSexo(),
			funcionarios.getCpf(),
			funcionarios.getEmail(),
			funcionarios.getTelefone(),
			funcionarios.getProfissao());
	}
	
}
