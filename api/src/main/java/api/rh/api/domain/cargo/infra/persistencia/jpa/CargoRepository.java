package api.rh.api.domain.cargo.infra.persistencia.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import api.rh.api.domain.cargo.entity.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long>{

}
