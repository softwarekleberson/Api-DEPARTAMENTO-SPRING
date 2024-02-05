package api.rh.api.domain.cargo.infra.persistencia.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import api.rh.api.domain.cargo.entity.Cargo;
import api.rh.api.domain.cargo.infra.web.dto.post.NivelEstagio;

public interface CargoRepositoryJpa extends JpaRepository<Cargo, Long>{

	Page<Cargo> findByAtivoTrue(Pageable paginacao);

	boolean existsByNome(String nome);
	boolean existsByNivel(NivelEstagio existeGerente);

	@Query("""
			
			select c from Cargo c
			where c.id = :idFuncionario
			
			""")
	Cargo recuperaCargo(Long idFuncionario);
	
	
	@Query("""
			
			SELECT COUNT(c) > 0
			FROM Cargo c
			WHERE c.nivel = GERENTE
			AND c.departamento.id = :idDepartamento

		   """)
	boolean verificaExistenciaGerente(Long idDepartamento);
	
}
