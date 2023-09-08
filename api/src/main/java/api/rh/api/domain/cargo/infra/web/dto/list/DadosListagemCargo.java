package api.rh.api.domain.cargo.infra.web.dto.list;

import api.rh.api.domain.cargo.entity.Cargo;
import api.rh.api.domain.cargo.infra.web.dto.post.NivelEstagio;

public record DadosListagemCargo(
		
		String nome,
		String descricao,
		NivelEstagio nivel) {
	
	public DadosListagemCargo(Cargo cargo) {
		this(cargo.getNome(), cargo.getDescricao(), cargo.getNivel());
	}
}
