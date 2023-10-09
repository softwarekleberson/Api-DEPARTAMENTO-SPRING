package api.rh.api.domain.cargo.usecase.crud;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import api.rh.api.domain.cargo.entity.Cargo;
import api.rh.api.domain.cargo.infra.persistencia.jpa.CargoRepositoryJpa;
import api.rh.api.domain.cargo.infra.web.dto.list.DadosListagemCargo;
import api.rh.api.domain.cargo.infra.web.dto.put.DadosAtualizarCargo;
import api.rh.api.domain.cargo.usecase.CargoRepository;
import jakarta.validation.Valid;

public class CargoDaoJpa implements CargoRepository{

	private CargoRepositoryJpa cargorepositoty;
	
	public CargoDaoJpa(CargoRepositoryJpa cargoRepository) {
		this.cargorepositoty = cargoRepository;
	}
	
	@Override
	public void executeCreate(Cargo cargo) {
		cargorepositoty.save(cargo);
	}

	@Override
	public Cargo listAllDate(Long id) {
		var cargo = cargorepositoty.getReferenceById(id);
		return cargo;
	}

	@Override
	public Cargo updateData(@Valid DadosAtualizarCargo dados) {
		Optional<Cargo> opDataBaseCargo = cargorepositoty.findById(dados.id());
		
		if(opDataBaseCargo.isPresent()) {
			Cargo databaseCargo = opDataBaseCargo.get();
			
			if(dados.nome() != null) {
				databaseCargo.setNome(dados.nome());
			}
			
			if(dados.descricao() != null) {
				databaseCargo.setDescricao(dados.descricao());
			}
			
			if(dados.salarioBase() != null) {
				databaseCargo.setSalario_Base(dados.salarioBase());
			}
			
			if(dados.salarioMaximo() != null) {
				databaseCargo.setSalario_Maximo(dados.salarioMaximo());
			}
			
			cargorepositoty.save(databaseCargo);
			return databaseCargo;
		}
		return null;
	}

	@Override
	public void exclusionLogic(Long id) {
		var cargo = cargorepositoty.getReferenceById(id);
		exclusion(cargo);
	}
	
	@Override
	public void exclusion(Cargo cargo) {
		cargo.setAtivo(false);
	}

	@Override
	public Page listAssets(Pageable paginacao) {
		return cargorepositoty.findByAtivoTrue(paginacao).map(DadosListagemCargo::new);
	}
}
