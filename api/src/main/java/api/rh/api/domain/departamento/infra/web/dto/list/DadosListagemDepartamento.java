package api.rh.api.domain.departamento.infra.web.dto.list;

import api.rh.api.commun.domain.humanResource.contato.Email;
import api.rh.api.commun.domain.humanResource.contato.Telefone;
import api.rh.api.domain.departamento.entity.Departamento;

public record DadosListagemDepartamento(
		
		String nome,
		String descricao,
		Telefone telefone,
		Email email
		
		) {
	
		public DadosListagemDepartamento(Departamento departamento) {
			this(departamento.getNome(), departamento.getDescricao(),
				departamento.getTelefone(), departamento.getEmail());
		}
}
