package api.rh.api.domain.reajusteSalarialNivelProfissional.usecase.crud;

import api.rh.api.domain.reajusteSalarialNivelProfissional.entity.ReajusteSalarioCargo;

public interface ReajusteSalarialRepository {

	void executeCreate(ReajusteSalarioCargo reajuste);
	ReajusteSalarioCargo listAllDate(Long id);
}
