package api.rh.api.domain.cargo.usecase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import api.rh.api.domain.cargo.entity.Cargo;
import api.rh.api.domain.cargo.infra.web.dto.put.DadosAtualizarCargo;
import jakarta.validation.Valid;

public interface CargoRepository {

	void executeCreate(Cargo cargo);
	Cargo listAllDate(Long id);
	Cargo updateData(@Valid DadosAtualizarCargo dados);
	void exclusionLogic(Long id);
	void exclusion(Cargo cargo);
	Page listAssets (Pageable paginacao);
	
}
