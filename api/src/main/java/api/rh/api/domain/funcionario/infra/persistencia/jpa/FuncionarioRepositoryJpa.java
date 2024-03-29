package api.rh.api.domain.funcionario.infra.persistencia.jpa;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import api.rh.api.commun.domain.humanResource.cpf.Cpf;
import api.rh.api.domain.funcionario.entity.Funcionario;

public interface FuncionarioRepositoryJpa extends JpaRepository<Funcionario, Long>{

	Page<Funcionario> findByAtivoTrue(Pageable paginacao);

	boolean existsByCpfAndAtivoTrue(Cpf cpfconsulta);

	Optional<Funcionario> findByCpfAndAtivoTrue(Cpf cpf);

	Funcionario findByIdAndAtivoTrue(Long idFuncionario);
	
}
