package api.rh.api.domain.projetos.infra.persistencia.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import api.rh.api.domain.projetos.entity.Projeto;

public interface ProjetoRepositoryJpa extends JpaRepository<Projeto, Long>{

	Page<Projeto> findByAtivoTrue(Pageable paginacao);
}
