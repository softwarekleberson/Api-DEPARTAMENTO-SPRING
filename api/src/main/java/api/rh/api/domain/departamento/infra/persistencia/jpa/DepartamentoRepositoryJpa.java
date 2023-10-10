package api.rh.api.domain.departamento.infra.persistencia.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import api.rh.api.domain.departamento.entity.Departamento;

public interface DepartamentoRepositoryJpa extends JpaRepository<Departamento, Long>{

	Page<Departamento> findByAtivoTrue(Pageable paginacao);

}
