package api.rh.api.domain.cargo.infra.web.dto.put;

import java.math.BigDecimal;

import api.rh.api.domain.cargo.entity.Cargo;
import api.rh.api.domain.cargo.infra.web.dto.post.NivelEstagio;

public record DadosDetalhamentoCargo(Long id, String nome, String descricao,
		BigDecimal salarioBase, BigDecimal salarioMaximo, NivelEstagio nivel) 
{

	public DadosDetalhamentoCargo(Cargo cargo) {
		this(cargo.getId(), cargo.getNome(), cargo.getDescricao(),
			 cargo.getSalario_Base(), cargo.getSalario_Maximo(),
			 cargo.getNivel());
																	}

}
