package api.rh.api.domain.funcionario.infra.persistencia.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import api.rh.api.domain.funcionario.entity.Funcionario;

public interface FuncionarioRepositoryJpa extends JpaRepository<Funcionario, Long>{

	Page<Funcionario> findByAtivoTrue(Pageable paginacao);

	boolean existsByCpf(String cpf);

}
