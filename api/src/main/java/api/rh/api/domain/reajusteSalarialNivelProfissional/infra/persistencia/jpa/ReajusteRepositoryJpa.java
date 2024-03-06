package api.rh.api.domain.reajusteSalarialNivelProfissional.infra.persistencia.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import api.rh.api.commun.domain.humanResource.cpf.Cpf;
import api.rh.api.domain.reajusteSalarialNivelProfissional.entity.ReajusteSalarioCargo;

public interface ReajusteRepositoryJpa extends JpaRepository<ReajusteSalarioCargo, Long>{

	Optional<ReajusteSalarioCargo> findByCpfFuncionario(Cpf cpf);

}
