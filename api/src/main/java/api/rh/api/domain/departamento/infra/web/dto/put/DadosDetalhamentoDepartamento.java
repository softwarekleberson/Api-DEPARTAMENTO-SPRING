package api.rh.api.domain.departamento.infra.web.dto.put;

import java.time.LocalDate;

import api.rh.api.commun.domain.humanResource.contato.Email;
import api.rh.api.commun.domain.humanResource.contato.Telefone;
import api.rh.api.commun.domain.humanResource.endereco.Endereco;
import api.rh.api.domain.departamento.entity.Departamento;

public record DadosDetalhamentoDepartamento(Long id, String nome, String descricao,
		LocalDate criacao, Telefone telefone, Email email, Endereco endereco
		) {

	public DadosDetalhamentoDepartamento(Departamento departamento) {
		this(departamento.getId(), departamento.getNome(),
			 departamento.getDescricao(), departamento.getCriacao(),
			 departamento.getTelefone(), departamento.getEmail(),
			 departamento.getEndereco());
	}

	
}
