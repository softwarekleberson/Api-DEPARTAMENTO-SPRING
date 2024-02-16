package api.rh.api.domain.reajusteSalarialNivelProfissional.infra.persistencia.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import api.rh.api.domain.reajusteSalarialNivelProfissional.entity.ReajusteSalarioCargo;

public interface ReajusteRepositoryJpa extends JpaRepository<ReajusteSalarioCargo, Long>{

}
