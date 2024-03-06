package api.rh.api.domain.reajusteSalarialNivelProfissional.infra.web.dto.post;

import java.math.BigDecimal;
import java.time.LocalDate;

import api.rh.api.domain.reajusteSalarialNivelProfissional.entity.ReajusteSalarioCargo;

public record DadosDetalhamentoReajuste( long id,
										 LocalDate diaReajuste,
										 String motivoPromocao,
										 BigDecimal valorReajuste
										 ){
	
	
	public DadosDetalhamentoReajuste(ReajusteSalarioCargo reajuste) {
		this(reajuste.getId(),
			 reajuste.getDiaReajuste(),
			 reajuste.getMotivoReajuste(),
			 reajuste.getValorReajuste());
	}
}