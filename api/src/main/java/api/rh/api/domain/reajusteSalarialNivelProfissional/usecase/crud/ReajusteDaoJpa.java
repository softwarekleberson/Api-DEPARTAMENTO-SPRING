package api.rh.api.domain.reajusteSalarialNivelProfissional.usecase.crud;

import org.springframework.stereotype.Service;

import api.rh.api.domain.reajusteSalarialNivelProfissional.entity.ReajusteSalarioCargo;
import api.rh.api.domain.reajusteSalarialNivelProfissional.infra.persistencia.jpa.ReajusteRepositoryJpa;

@Service
public class ReajusteDaoJpa implements ReajusteSalarialRepository{

	private ReajusteRepositoryJpa repository;
	
	public ReajusteDaoJpa(ReajusteRepositoryJpa repository) {
		this.repository = repository;
	}
	
	@Override
	public void executeCreate(ReajusteSalarioCargo reajuste) {
		repository.save(reajuste);
	}

	@Override
	public ReajusteSalarioCargo listAllDate(Long id) {
		return repository.getReferenceById(id);
	}
}
