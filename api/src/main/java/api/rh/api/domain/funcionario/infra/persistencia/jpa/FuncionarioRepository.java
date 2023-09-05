package api.rh.api.domain.funcionario.infra.persistencia.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import api.rh.api.domain.funcionario.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
